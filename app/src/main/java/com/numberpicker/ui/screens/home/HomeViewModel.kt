package com.numberpicker.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

class HomeViewModel : ViewModel() {

    private val _randomNumber = MutableStateFlow<Int?>(null)
    val randomNumber: StateFlow<Int?> = _randomNumber

    fun drawRandomNumber() {
        viewModelScope.launch {
            val number = Random.nextInt(1, 101)
            _randomNumber.value = number
        }
    }

    fun resetDraw() {
        _randomNumber.value = null
    }
}
