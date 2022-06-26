package me.bongle.common.ui.layout.player

import kotlinx.coroutines.flow.MutableStateFlow
import me.bongle.common.data.model.PlayerState
import me.bongle.common.data.model.Song
import me.bongle.common.data.model.State
import me.bongle.common.util.ViewModel

class MusicPlayerViewModel(
    val playerState: PlayerState,
) : ViewModel() {

    val likedSongList: MutableStateFlow<State<List<Song>>?> = MutableStateFlow(null)

    fun changeSongLikeState(song: Song) {

    }

}

enum class RepeatMode {
    NONE, LIST, SINGLE
}