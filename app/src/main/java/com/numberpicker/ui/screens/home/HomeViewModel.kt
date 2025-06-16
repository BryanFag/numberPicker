package com.numberpicker.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

class HomeViewModel : ViewModel() {

    private val _randomNumber = MutableStateFlow<List<Int>>(emptyList())
    val randomNumber: StateFlow<List<Int>> = _randomNumber

    fun drawRandomNumber(quantity: Int, minValue: Int, maxValue: Int, noRepeatNumber: Boolean) {
        viewModelScope.launch {
            val number = if (noRepeatNumber) {
                val range = (minValue..maxValue).toList().shuffled()
                range.take(quantity)
            } else {
                List(quantity) { Random.nextInt(minValue, maxValue + 1) }
            }
            _randomNumber.value = number
        }
    }
}
