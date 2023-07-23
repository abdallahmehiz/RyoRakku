package xyz.mehiz.ryorakku.ui.components.webview

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.web.AccompanistWebViewClient
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewNavigator
import com.google.accompanist.web.rememberWebViewState
import xyz.mehiz.ryorakku.ui.webview.WebViewActivity

@SuppressLint("SetJavaScriptEnabled")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WebViewScreen(
  url: String,
  initialTitle: String = "Loading..."
) {
  val state = rememberWebViewState(url = url)
  val navigator = rememberWebViewNavigator()

  Column {
    TopAppBar(
      title = { Text(text = state.pageTitle ?: initialTitle) },
      navigationIcon = {
        val context = LocalContext.current
        IconButton(onClick = {
          (context as? WebViewActivity)?.finish()
        }) {
          Icon(
            imageVector = Icons.Outlined.Close,
            contentDescription = "stuff"
          )
        }
      },
    )
    WebView(
      modifier = Modifier.fillMaxSize(),
      state = state,
      navigator = navigator,
      onCreated = { webView ->
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
      },
      client = AccompanistWebViewClient()
    )
  }
}
