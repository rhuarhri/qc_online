package com.three_squared.qc_online

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class itemListViewModel : ViewModel() {

    val repository = itemListRepository()
    var menu : MutableLiveData<List<Item>> = MutableLiveData(listOf())

    fun getMenu() {
            viewModelScope.launch(Dispatchers.IO) {
                val bagels = repository.getMenu()

                withContext(Dispatchers.Main) {
                    menu.value = bagels
                }
            }
    }

    fun onlyBagels() {

    }

    fun onlyCrisps() {

    }

    fun onlyDrinks() {

    }
}