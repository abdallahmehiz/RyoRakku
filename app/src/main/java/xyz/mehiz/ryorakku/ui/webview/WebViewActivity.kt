package xyz.mehiz.ryorakku.ui.webview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import xyz.mehiz.ryorakku.ui.components.webview.WebViewScreen
import xyz.mehiz.ryorakku.ui.theme.RyoRakkuTheme

class WebViewActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      RyoRakkuTheme {
        WebViewScreen(url = "https://google.com/")
      }
    }
  }
}
