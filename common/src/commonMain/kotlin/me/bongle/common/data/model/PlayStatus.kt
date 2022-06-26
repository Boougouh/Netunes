package me.bongle.common.data.model

sealed class PlayStatus {

    data class Playing(val song: Song) : PlayStatus()
    data class Pause(val song: Song) : PlayStatus()
    object None : PlayStatus()

}