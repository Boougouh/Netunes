package me.bongle.common.platform

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancel

actual abstract class ViewModel : androidx.lifecycle.ViewModel() {

    actual val coroutineScope = viewModelScope

    actual fun dispose() {
        viewModelScope.cancel()
        onCleared()
    }

    actual override fun onCleared() {
        super.onCleared()
    }

}