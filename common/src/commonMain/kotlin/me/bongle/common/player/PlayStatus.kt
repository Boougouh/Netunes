package me.bongle.common.player

sealed class PlayStatus<out Song> {

    data class Playing<T>(val song: T) : PlayStatus<T>()
    data class Pause<T>(val song: T) : PlayStatus<T>()
    object None : PlayStatus<Nothing>()

}