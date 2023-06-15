package xyz.mehiz.ryorakku.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.NavigatorDisposeBehavior
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import xyz.mehiz.ryorakku.ui.home.HomeScreen
import kotlin.time.Duration.Companion.seconds

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      Navigator(
        screen = HomeScreen(),
        disposeBehavior = NavigatorDisposeBehavior(
          disposeNestedNavigators = false,
          disposeSteps = true
        )
      )
      { navigator ->
        if (navigator.size == 1) {
          ConfirmExit()
        }
        CurrentScreen()
      }
    }
  }
}

@Composable
private fun ConfirmExit() {
  val scope = rememberCoroutineScope()
  val context = LocalContext.current
  var waitingConfirmation by remember { mutableStateOf(false) }
  BackHandler(enabled = !waitingConfirmation) {
    scope.launch {
      waitingConfirmation = true
      Toast.makeText(context, "Back again to exit", Toast.LENGTH_SHORT).show()
      delay(2.seconds)
      waitingConfirmation = false
    }
  }
}