package xyz.mehiz.ryorakku.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.TabNavigator
import xyz.mehiz.ryorakku.ui.home.anime.AnimeTab
import xyz.mehiz.ryorakku.ui.home.calendar.CalendarTab
import xyz.mehiz.ryorakku.ui.home.discover.DiscoverTab
import xyz.mehiz.ryorakku.ui.home.manga.MangaTab
import xyz.mehiz.ryorakku.ui.home.profile.ProfileTab
import xyz.mehiz.ryorakku.ui.theme.RyoRakkuTheme

@Composable
fun HomeScreen() {
  val tabs = listOf(
    AnimeTab,
    MangaTab,
    DiscoverTab,
    CalendarTab,
    ProfileTab
  )

  RyoRakkuTheme {
    TabNavigator(DiscoverTab) {
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
    alwaysShowLabel = true,
  )
}
