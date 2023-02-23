package com.pavlo.pavlopractice.demo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    val currentValueLiveData = MutableLiveData(0)

    fun increment() {
        currentValueLiveData.value = currentValueLiveData.value?.plus(1)
    }

    fun decrement() {
        currentValueLiveData.value = currentValueLiveData.value?.minus(1)
    }
}
