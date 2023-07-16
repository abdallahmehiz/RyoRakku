package xyz.mehiz.ryorakku.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import xyz.mehiz.ryorakku.ui.home.HomeScreen
import xyz.mehiz.ryorakku.ui.onboarding.OnBoardingScreen

/* TODO
* Remove the usage of NavGraphs and Google's recommended way of navigation
* as it doesn't suit the needs of this app.
*  */
@Composable
fun SetupNavGraph(navController: NavHostController, startDestination: String) {
  NavHost(
    navController = navController,
    startDestination = startDestination
  ) {
    // add composable routes here
    composable(route = Route.Home.route) { HomeScreen() }
    composable(route = Route.OnBoarding.route) { OnBoardingScreen(navController = navController) }
  }
}
