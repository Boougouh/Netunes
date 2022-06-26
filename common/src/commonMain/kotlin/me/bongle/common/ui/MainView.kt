package me.bongle.common.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import me.bongle.common.data.model.PlayerState
import me.bongle.common.ui.layout.player.MusicPlayer
import me.bongle.common.ui.layout.player.MusicPlayerViewModel

@Composable
fun MainView() {

    val musicPlayer = remember {
        MusicPlayerViewModel(PlayerState())
    }

    Theme {
        Surface {
            MusicPlayer(musicPlayer)
        }
    }

}

@Composable
fun Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {

    MaterialTheme(
        colors = if (darkTheme) DarkColors else LightColors,
        content = content
    )

}

private val DarkColors = darkColors(
    primary = Color.DarkGray
)

private val LightColors = lightColors(
    primary = Color.White
)