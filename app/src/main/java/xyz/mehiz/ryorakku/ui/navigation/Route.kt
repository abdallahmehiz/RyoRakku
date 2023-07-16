package xyz.mehiz.ryorakku.ui.navigation

sealed class Route(val route: String) {
  // Since Google wants compose navigation to be like web navigation
  // all of the app routes should follow the same rules as web routes
  // so we'll use the same naming convention as web routes.
  object Home : Route(route = "/home")
  object OnBoarding : Route(route = "/onboarding")
}
