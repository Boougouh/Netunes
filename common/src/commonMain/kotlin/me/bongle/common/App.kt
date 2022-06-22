package me.bongle.common

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import me.bongle.common.layout.main.BottomBar
import me.bongle.common.player.PlayerSettings

@Composable
fun App() {

    val settings = PlayerSettings()

    Theme {
        Column(modifier = Modifier.fillMaxSize().background(Color.White)) {
            Box(Modifier.weight(1f)) {

            }
            BottomBar(settings)
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