package xyz.mehiz.ryorakku.ui.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import xyz.mehiz.ryorakku.ui.navigation.SetupNavGraph
import xyz.mehiz.ryorakku.ui.splashscreen.SplashViewModel
import xyz.mehiz.ryorakku.ui.theme.RyoRakkuTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  @Inject
  lateinit var splashViewModel: SplashViewModel

  private lateinit var navController: NavHostController
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    installSplashScreen().setKeepOnScreenCondition { splashViewModel.isLoading.value }
    setContent {
      RyoRakkuTheme {
        val screen by splashViewModel.startDestination
        navController = rememberNavController()
        Log.d("MainActivity", "onCreate: current destination is $screen")
        SetupNavGraph(navController = navController, startDestination = screen)
      }
    }
  }
}
