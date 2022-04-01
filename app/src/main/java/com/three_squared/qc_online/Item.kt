package com.three_squared.qc_online

data class Item(
    var id : String,
    var name : String,
    var price : Double,
    var description : String,
    var inStock : Boolean,
    var kind : String,
)
