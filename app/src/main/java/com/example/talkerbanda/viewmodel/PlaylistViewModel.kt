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
            Track("Justice", "WithoutAuthor", R.raw.track1),
            Track("Battle", "WithoutAuthor", R.raw.track2),
            Track("Best", "WithoutAuthor", R.raw.track3),
            Track("Back", "WithoutAuthor", R.raw.track4),
            Track("Village", "WithoutAuthor", R.raw.track5),
            // Добавьте здесь другие треки, указывая соответствующие ресурсные ID
        )
    }
}








