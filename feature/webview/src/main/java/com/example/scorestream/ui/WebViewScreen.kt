import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebViewScreen() {
    var url by remember { mutableStateOf("https://allsportsapi.com/") }
    val state = rememberWebViewState(url = url)

    WebView(
        state = state,
        onCreated = { it.settings.javaScriptEnabled = true }
    )
}
