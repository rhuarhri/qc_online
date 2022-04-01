package com.three_squared.qc_online

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {


    var bagelList : MutableLiveData<List<String>> = MutableLiveData(listOf())

}