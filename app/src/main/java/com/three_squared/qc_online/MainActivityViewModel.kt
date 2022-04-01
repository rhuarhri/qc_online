package com.three_squared.qc_online

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel : ViewModel() {

    var repository = MainActivityRepository()

    var menu : MutableLiveData<List<Item>> = MutableLiveData(listOf())



}