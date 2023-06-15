package xyz.mehiz.ryorakku.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.TabNavigator
import xyz.mehiz.ryorakku.ui.anime.AnimeTab
import xyz.mehiz.ryorakku.ui.calendar.CalendarTab
import xyz.mehiz.ryorakku.ui.discover.DiscoverTab
import xyz.mehiz.ryorakku.ui.manga.MangaTab
import xyz.mehiz.ryorakku.ui.profile.ProfileTab
import xyz.mehiz.ryorakku.ui.theme.RyoRakkuTheme

class HomeScreen: Screen {
  private val tabs = listOf(
    AnimeTab,
    MangaTab,
    DiscoverTab,
    CalendarTab,
    ProfileTab
  )
  @OptIn(ExperimentalMaterial3Api::class)
  @Composable
  override fun Content(){
    RyoRakkuTheme {
      TabNavigator(AnimeTab) {
        Scaffold(
          content = { padding ->
            Column(modifier = Modifier.padding(padding))
            {
              CurrentScreen()
            }
          },
          bottomBar = {
            NavigationBar {
              tabs.forEach {
                NavigationBarItem(it)
              }
            }
          }
        )
      }
    }
  }
}


// Re write NavigationBarItem to use TabNavigator
// Snippet Inspired from "Tachiyomi"
@Composable
private fun RowScope.NavigationBarItem(tab: cafe.adriel.voyager.navigator.tab.Tab) {
  val tabNavigator = LocalTabNavigator.current
  val selected = tabNavigator.current::class == tab::class
  NavigationBarItem(
    selected = selected,
    onClick = {
      tabNavigator.current = tab
    },
    icon = { tab.options.icon?.let { Icon(painter = it, contentDescription = null) } },
    label = {
      Text(
        text = tab.options.title,
        maxLines = 1,
      )
    },
    alwaysShowLabel = false,
  )
}
