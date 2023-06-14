package xyz.mehiz.ryorakku.ui.navigation

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import xyz.mehiz.ryorakku.ui.anime.AnimeScreen
import xyz.mehiz.ryorakku.ui.calendar.CalendarScreen
import xyz.mehiz.ryorakku.ui.discover.DiscoverScreen
import xyz.mehiz.ryorakku.ui.manga.MangaScreen
import xyz.mehiz.ryorakku.ui.profile.ProfileScreen


@Composable
fun SetupNavGraph(
  navController: NavHostController
) {
  NavHost(
    navController = navController,
    startDestination = ScreenRouter.AnimeScreen.route
  ) {
    composable(
      route = ScreenRouter.AnimeScreen.route,
    ) {
      AnimeScreen(navController)
    }
    composable(
      route = ScreenRouter.MangaScreen.route,
    ) {
      MangaScreen(navController)
    }
    composable(
      route = ScreenRouter.DiscoverScreen.route,
    ) {
      DiscoverScreen(navController)
    }
    composable(
      route = ScreenRouter.CalendarScreen.route,
    ) {
      CalendarScreen(navController)
    }
    composable(
      route = ScreenRouter.ProfileScreen.route,
    ) {
      ProfileScreen(navController)
    }
  }
}