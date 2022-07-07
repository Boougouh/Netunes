package me.bongle.common.ui.layout.player

import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import me.bongle.common.data.model.PlayerState
import me.bongle.common.data.model.Song
import me.bongle.common.data.model.State
import me.bongle.common.platform.ViewModel

class MusicPlayerViewModel(
    val playerState: PlayerState,
) : ViewModel() {

    val likedSongList: MutableStateFlow<State<List<Song>>?> = MutableStateFlow(null)

    fun changeSongLikeState(song: Song) {
        coroutineScope.launch {
            val state = likedSongList.value
            if (state is State.Content) {
                val likeList = state.data.toMutableList()
                if (likeList.contains(song)) {
                    likeList.remove(song)
                } else {
                    likeList.add(song)
                }
                likedSongList.value = State.Content(likeList)
            }
        }
    }

    fun loadLikeList() {

    }
}

enum class RepeatMode {
    NONE, LIST, SINGLE
}