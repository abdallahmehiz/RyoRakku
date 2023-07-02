package xyz.mehiz.ryorakku.ui.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import xyz.mehiz.ryorakku.ui.home.HomeScreen

class OnBoardingScreen : Screen {
  val pages = listOf(
    OnBoardingPage.First,
    OnBoardingPage.Second,
    OnBoardingPage.Third
  )

  @OptIn(ExperimentalFoundationApi::class)
  @Composable
  @Preview
  override fun Content() {
    val pagerState = rememberPagerState(0, 0f) { pages.size }
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
      HorizontalPager(state = pagerState) { page ->
        PagerScreen(onBoardingPage = pages[page])
      }
      FinishPrompt(pagerState = pagerState)
    }
  }
}

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage) {
  Column(verticalArrangement = Arrangement.Center) {
    Text(
      text = onBoardingPage.title,
      fontSize = 24.sp
    )
    Text(
      text = onBoardingPage.description,
      fontSize = 16.sp
    )
  }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FinishPrompt(
  pagerState: PagerState,
) {
  AnimatedVisibility(visible = pagerState.currentPage == 2) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
      Button(onClick = { /*TODO*/ }) {
        Text(text = "Login")
      }
      val navigator = LocalNavigator.current
      OutlinedButton(onClick = { navigator?.replaceAll(HomeScreen()) }) {
        Text(text = "Skip")
      }
    }
  }
}
