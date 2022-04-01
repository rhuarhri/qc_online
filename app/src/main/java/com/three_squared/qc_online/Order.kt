package com.three_squared.qc_online

import java.util.*

data class Order(
    var id : String,
    var items : List<Item>,
    var timeOrdered : Date,
    var expected : Boolean,
    var name : String,
    var state : String,

    )
