package me.bongle.common.platform.model.login

sealed class LoginStatus<out T> {

    object Loading : LoginStatus<Nothing>()
    data class Content<T>(val data: T) : LoginStatus<T>()
    data class Error(val ex: Exception) : LoginStatus<Nothing>()

}