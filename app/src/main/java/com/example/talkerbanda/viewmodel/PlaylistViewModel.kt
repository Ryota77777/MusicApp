package com.example.talkerbanda.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.talkerbanda.R
import com.example.talkerbanda.playlist.Track

class PlaylistViewModel : ViewModel() {

    private val _searchQuery = MutableLiveData<String>()
    val searchQuery: LiveData<String>
        get() = _searchQuery

    private val _tracks = MutableLiveData<List<Track>>()
    val tracks: LiveData<List<Track>>
        get() = _tracks

    init {
        loadTracks()
    }

    private fun loadTracks() {
        // Пример загрузки треков с указанием ресурсных ID аудиофайлов из папки res/raw
        _tracks.value = listOf(
            Track("I Got You", "Toxi$", R.raw.track1),
            Track("Еще один день", "Мот", R.raw.track2),
            Track("Юморист", "Face", R.raw.track3),
            Track("Это любовь", "Скриптонит", R.raw.track4),
            Track("I Got Love", "Мияги, Рем Дигга", R.raw.track5),
            // Добавьте здесь другие треки, указывая соответствующие ресурсные ID
        )
    }
}








