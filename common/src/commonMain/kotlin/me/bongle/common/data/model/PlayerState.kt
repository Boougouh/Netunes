package me.bongle.common.data.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class PlayerState {

    var playStatus by mutableStateOf<PlayStatus>(PlayStatus.Pause(Song("Test", "Test")))
    var shuffled by mutableStateOf(false)

}
