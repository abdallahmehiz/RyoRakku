package xyz.mehiz.ryorakku.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import xyz.mehiz.ryorakku.R
import xyz.mehiz.ryorakku.ui.navigation.SetupNavGraph
import xyz.mehiz.ryorakku.ui.theme.RyoRakkuTheme

class MainActivity : ComponentActivity() {

  private lateinit var navController: NavHostController
  private val navItems = listOf("Anime", "Manga", "Discover", "Calendar", "Profile")
  private var selectedItem by mutableStateOf(0)

  @OptIn(ExperimentalMaterial3Api::class)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      RyoRakkuTheme {
        navController = rememberNavController()

        Scaffold(
          content = { padding ->
            Column(modifier = Modifier.padding(padding)) {
              SetupNavGraph(navController = navController)
            }
          },
          bottomBar = {
            NavigationBar {
              navItems.forEachIndexed { index, item ->
                NavigationBarItem(
                  icon = {
                    Icon(
                      when (index) {
                        0 -> painterResource(id = R.drawable.outline_video_library_24)
                        1 -> painterResource(id = R.drawable.outline_collections_bookmark_24)
                        2 -> painterResource(id = R.drawable.outline_explore_24)
                        3 -> painterResource(id = R.drawable.outline_calendar_month_24)
                        4 -> painterResource(id = R.drawable.outline_account_box_24)
                        else -> painterResource(id = R.drawable.ic_launcher_foreground)
                      },
                      contentDescription = item
                    )
                  },
                  label = { Text(item) },
                  selected = selectedItem == index,
                  onClick = {
                    selectedItem = index
                    navController.navigate(route = item + "Screen") {
                      popUpTo(navController.graph.startDestinationId)
                      launchSingleTop = true
                    }
                  }
                )
                // it worked, somehow
                BackHandler(enabled = true, onBack = {
                  if(selectedItem == 0) finish() else selectedItem = 0
                })
              }
            }
          }
        )
      }
    }
  }
}