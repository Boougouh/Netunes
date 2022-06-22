package me.bongle.common.layout.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import me.bongle.common.layout.Res
import me.bongle.common.platform.painterResource
import me.bongle.common.player.PlayStatus
import me.bongle.common.player.PlayerSettings

@Composable
fun BottomBar(settings: PlayerSettings) {
    Box(contentAlignment = Alignment.Center) {
        Row(Modifier.height(50.dp)) {
            PrevSong(settings)
            PlayButton(settings)
            NextSong(settings)
        }
    }
}

@Composable
fun NextSong(settings: PlayerSettings) {
    BarItem(painterResource(Res.Icon.NEXT), "下一首", Color.Black)
}

@Composable
fun PlayButton(settings: PlayerSettings) {
    when (val state = settings.playStatus) {
        is PlayStatus.Playing -> {
            BarItem(painterResource(Res.Icon.PAUSE), "暂停", Color.Black) {
                settings.playStatus = PlayStatus.Pause(state.song)
            }
        }
        is PlayStatus.Pause -> {
            BarItem(painterResource(Res.Icon.PLAY), "播放", Color.Black) {
                settings.playStatus = PlayStatus.Playing(state.song)
            }
        }
        PlayStatus.None -> {}
    }
}

@Composable
fun PrevSong(settings: PlayerSettings) {
    BarItem(painterResource(Res.Icon.PREV), "上一首", Color.Black)
}

@Composable
fun BarItem(painter: Painter, desc: String, tint: Color, onClick: () -> Unit = {}) {
    Button(
        modifier = Modifier.width(40.dp).height(40.dp),
        onClick = onClick,
        shape = CircleShape
    ) {
        Icon(painter, desc, Modifier.fillMaxSize(), tint = tint)
    }
}