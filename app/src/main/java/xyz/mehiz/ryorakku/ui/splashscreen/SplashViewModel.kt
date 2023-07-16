package xyz.mehiz.ryorakku.ui.splashscreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import xyz.mehiz.ryorakku.data.DataStoreRepository
import xyz.mehiz.ryorakku.data.preferences.PreferencesKeys
import xyz.mehiz.ryorakku.ui.navigation.Route
import javax.inject.Inject

class SplashViewModel @Inject constructor(
  private val dataStoreRepository: DataStoreRepository
) : ViewModel() {
  private val _isLoading: MutableState<Boolean> = mutableStateOf(true)
  var isLoading: State<Boolean> = _isLoading

  private val _startDestination: MutableState<String> = mutableStateOf(Route.Home.route)
  var startDestination: State<String> = _startDestination

  init {
    viewModelScope.launch {
      dataStoreRepository.readBoolean(PreferencesKeys.onBoardingComplete).collect { value ->
        if (!value) _startDestination.value = Route.OnBoarding.route
        _isLoading.value = false
      }
    }
  }
}
