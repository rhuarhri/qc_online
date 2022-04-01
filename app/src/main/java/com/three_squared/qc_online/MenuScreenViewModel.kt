package com.three_squared.qc_online

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MenuScreenViewModel : ViewModel() {

    val repo = MenuScreenRepository()

    var productList : MutableLiveData<List<Item>> = MutableLiveData(listOf())

    fun getMenu() {
        viewModelScope.launch(Dispatchers.IO) {
            val menu = repo.getMenu()
            withContext(Dispatchers.Main) {
                productList.value = menu
            }
        }
    }


}