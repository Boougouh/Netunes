package me.bongle.common.ui.layout.player

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.bongle.common.data.model.PlayStatus
import me.bongle.common.data.model.Song
import me.bongle.common.platform.painterResource
import me.bongle.common.ui.layout.Res
import me.bongle.common.ui.layout.component.BarItemWithAnime

@Composable
fun MusicPlayer(model: MusicPlayerViewModel) {
    Column(modifier = Modifier.fillMaxSize().background(Color.White)) {
        Box(Modifier.weight(1f)) {}
        BottomBar(model)
    }
}

@Composable
fun BottomBar(model: MusicPlayerViewModel) {
    Box(
        modifier = Modifier.height(50.dp).fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Box(modifier = Modifier.align(Alignment.TopStart)) {
            Info(model)
        }
        Box(modifier = Modifier.align(Alignment.Center)) {
            Switch(model)
        }
        Box(modifier = Modifier.align(Alignment.BottomEnd)) {
            Settings(model)
        }
    }
}

@Composable
fun Info(model: MusicPlayerViewModel) {

    val playStatus = model.playerState.playStatus
    val likedSongList by model.likedSongList.collectAsState()

    val song: Song? = when (playStatus) {
        is PlayStatus.Playing -> playStatus.song
        is PlayStatus.Pause -> playStatus.song
        PlayStatus.None -> null
    }

    if (song != null) {
        val (color, icon) = if (likedSongList?.read()?.contains(song) == true) {
            Color.Red to Res.Icon.LIKE
        } else {
            Color.Black to Res.Icon.UNLIKE
        }
        Row(
            modifier = Modifier.fillMaxHeight().padding(6.dp, 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Song Info
            Column {
                Text(song.name, fontSize = 16.sp, color = Color.Black)
                Spacer(Modifier.weight(1f))
                Text(song.author, fontSize = 10.sp, color = Color.Gray)
            }
            Spacer(Modifier.width(18.dp))
            BarItemWithAnime(painterResource(icon), color) {
                model.changeSongLikeState(song)
            }
        }
    }

}

@Composable
fun Switch(model: MusicPlayerViewModel) {
    Row(
        modifier = Modifier.padding(14.dp),
        horizontalArrangement = Arrangement.spacedBy(22.dp, Alignment.CenterHorizontally)
    ) {
        PrevSong(model)
        PlayButton(model)
        NextSong(model)
    }
}

@Composable
fun Settings(model: MusicPlayerViewModel) {
    val shuffled = model.playerState.shuffled
    Row(
        modifier = Modifier.fillMaxHeight().padding(6.dp, 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(13.dp, Alignment.CenterHorizontally)
    ) {
        BarItemWithAnime(painterResource(Res.Icon.LIST), Color.Black, size = 14.dp)
        BarItemWithAnime(painterResource(Res.Icon.SHUFFLE), Color.Black, size = 14.dp)
        BarItemWithAnime(
            painterResource(Res.Icon.SHUFFLE),
            if (shuffled) {
                Color(0, 100, 255)
            } else {
                Color.Black
            },
            size = 14.dp
        ) {
            model.playerState.shuffled = !model.playerState.shuffled
        }
        BarItemWithAnime(painterResource(Res.Icon.VOLUME), Color.Black, size = 14.dp)
    }
}

@Composable
fun NextSong(model: MusicPlayerViewModel) {
    BarItemWithAnime(
        painter = painterResource(Res.Icon.NEXT),
        tint = Color.Black,
        size = 20.dp,
        animDp = 3.dp
    )
}

@Composable
fun PlayButton(model: MusicPlayerViewModel) {
    val (playing, song) = when (val state = model.playerState.playStatus) {
        is PlayStatus.Playing -> {
            true to state.song
        }
        is PlayStatus.Pause -> {
            false to state.song
        }
        PlayStatus.None -> return
    }
    BarItemWithAnime(
        painter = painterResource(if (playing) Res.Icon.PAUSE else Res.Icon.PLAY),
        tint = Color.Black,
        size = 20.dp,
        animDp = 3.dp
    ) {
        if (playing) {
            model.playerState.playStatus = PlayStatus.Pause(song)
        } else {
            model.playerState.playStatus = PlayStatus.Playing(song)
        }
    }
}

@Composable
fun PrevSong(model: MusicPlayerViewModel) {
    BarItemWithAnime(
        painter = painterResource(Res.Icon.PREV),
        tint = Color.Black,
        size = 20.dp,
        animDp = 3.dp
    )
}