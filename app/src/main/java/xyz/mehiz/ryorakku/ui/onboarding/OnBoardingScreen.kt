package xyz.mehiz.ryorakku.ui.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import xyz.mehiz.ryorakku.ui.navigation.Route

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
  onBoardingViewModel: OnBoardingViewModel = hiltViewModel(),
  navController: NavController
) {
  val pages = listOf(
    OnBoardingPages.First,
    OnBoardingPages.Second,
    OnBoardingPages.Third
  )
  val pagerState = rememberPagerState(0, 0f) { pages.size }
  Scaffold(
    modifier = Modifier.fillMaxSize(),
    topBar = {
      Button(onClick = {
        navController.popBackStack()
        navController.navigate(Route.Home.route)
        onBoardingViewModel.saveOnBoardingState(true)
      }) {
        Text(text = "Skip")
      }
    },
    bottomBar = {
      ExtendedFloatingActionButton(onClick = { /*TODO*/ }) {
        Text(text = "Skippp")
      }
    },
  ) { padding ->
    Box(modifier = Modifier.padding(padding)) {
      HorizontalPager(state = pagerState) { page ->
        PagerScreen(onBoardingPages = pages[page])
      }
    }
  }
}


@Composable
fun PagerScreen(onBoardingPages: OnBoardingPages) {
  Column(verticalArrangement = Arrangement.Center) {
    Text(
      text = onBoardingPages.title,
      fontSize = 24.sp
    )
    Text(
      text = onBoardingPages.description,
      fontSize = 16.sp
    )
  }
}
