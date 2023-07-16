package xyz.mehiz.ryorakku.ui.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import xyz.mehiz.ryorakku.data.DataStoreRepository
import xyz.mehiz.ryorakku.data.preferences.PreferencesKeys
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
  private val dataStoreRepository: DataStoreRepository
) : ViewModel() {
  fun saveOnBoardingState(completed: Boolean) {
    viewModelScope.launch(Dispatchers.IO) {
      dataStoreRepository.saveBoolean(PreferencesKeys.onBoardingComplete, completed)
    }
  }
}
