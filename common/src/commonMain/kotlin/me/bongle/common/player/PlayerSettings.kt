package me.bongle.common.player

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class PlayerSettings {

    var playStatus by mutableStateOf<PlayStatus<Song>>(PlayStatus.Pause(Song("Test", "Test")))

}