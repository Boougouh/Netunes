import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import me.bongle.common.ui.MainView

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Netunes",
        state = WindowState(size = DpSize(1330.dp, 840.dp))
    ) {
        Box(Modifier.padding(50.dp, 0.dp)) {
            MainView()
        }
    }
}

@Preview()
@Composable()
fun Preview() {
    MainView()
}
