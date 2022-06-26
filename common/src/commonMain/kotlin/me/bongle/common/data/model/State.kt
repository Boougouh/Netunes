package me.bongle.common.data.model

sealed class State<out T> {

    object Loading : State<Nothing>()
    data class Content<T>(val data: T) : State<T>()
    data class Error(val error: Throwable) : State<Nothing>()

    fun read(): T? = if (this is Content<T>) this.data else null

}