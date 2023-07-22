package xyz.mehiz.ryorakku.ui.home.manga

import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import xyz.mehiz.ryorakku.R

object MangaTab : Tab {
  @OptIn(ExperimentalAnimationGraphicsApi::class)
  override val options: TabOptions
    @Composable
    get() {
      val isSelected = LocalTabNavigator.current.current.key == key
      val title = "Manga"
      val image = AnimatedImageVector.animatedVectorResource(id = R.drawable.anim_mangalist)
      return TabOptions(
        index = 1u,
        title = title,
        icon = rememberAnimatedVectorPainter(image, isSelected)
      )
    }

  @Composable
  override fun Content() {
    Box(
      modifier = Modifier.fillMaxSize(),
      contentAlignment = Alignment.Center
    ) {
      Text(text = "Manga")
    }
  }
}
