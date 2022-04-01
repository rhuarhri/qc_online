package com.three_squared.qc_online

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel : ViewModel() {

    var repository = MainActivityRepository()

    var basket : MutableList<Item> = mutableListOf()

    fun addToBasket(item : Item) {
        basket.add(item)
    }

    fun removeFromBasket(item : Item) {
        basket.remove(item)
    }


}