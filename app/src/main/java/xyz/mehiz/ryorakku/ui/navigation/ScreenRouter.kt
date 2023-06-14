package xyz.mehiz.ryorakku.ui.navigation

sealed class ScreenRouter(val route: String) {
  object AnimeScreen : ScreenRouter("AnimeScreen")
  object MangaScreen : ScreenRouter("MangaScreen")
  object DiscoverScreen : ScreenRouter("DiscoverScreen")
  object CalendarScreen : ScreenRouter("CalendarScreen")
  object ProfileScreen : ScreenRouter("ProfileScreen")
}