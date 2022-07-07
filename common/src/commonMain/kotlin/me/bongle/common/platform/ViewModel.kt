package me.bongle.common.platform

import kotlinx.coroutines.CoroutineScope

expect abstract class ViewModel() {

    val coroutineScope : CoroutineScope

    fun dispose()

    protected open fun onCleared()

}