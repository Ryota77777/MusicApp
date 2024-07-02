package com.example.talkerbanda.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.talkerbanda.R

class HomeViewModel : ViewModel() {

    private val _userDescription = MutableLiveData<String>().apply {
        value = "Описание пользователя"
    }
    val userDescription: LiveData<String> = _userDescription

    private val _userPhoto = MutableLiveData<Int>().apply {
        value = R.drawable.user3
    }
    val userPhoto: LiveData<Int> = _userPhoto
}



