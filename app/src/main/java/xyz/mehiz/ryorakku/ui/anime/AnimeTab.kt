package xyz.mehiz.ryorakku.ui.anime

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import xyz.mehiz.ryorakku.R

object AnimeTab : Tab {
  override val options: TabOptions
    @Composable
    get() {
      val title = "Anime"
      val image = painterResource(id = R.drawable.outline_video_library_24)
      return TabOptions(index = 0u, title = title, icon = image)
    }

  @Composable
  override fun Content() {
    Box(
      modifier = Modifier.fillMaxSize(),
      contentAlignment = Alignment.Center
    ) {
      Text(text = "Anime")
    }
  }
}
