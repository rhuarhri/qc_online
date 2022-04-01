package com.three_squared.qc_online

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import java.util.*

class MainActivityRepository {

    private val retroFit : Retrofit by lazy {
        Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create())
            .baseUrl("https://api.github.com/").build()
    }

    private val basket : MutableList<Item> = mutableListOf()

    fun addToBasket(item : Item) {
        basket.add(item)
    }

    fun removeFromBasket(item : Item) {
        basket.remove(item)
    }

    fun getTotalPrice() : Double {
        return basket.map { it.price }.sum()
    }

    suspend fun setOrder(userName : String, items : List<Item>) {
        var order : Order = Order(
            id = UUID.randomUUID().toString(),
            timeOrdered = Date(),
            items = items,
            name = userName,
            expected = false,
            state = ""
        )

        val retrofitInterface = retroFit.create(RetroFitInterface::class.java)

        retrofitInterface.setOrder()

    }

    suspend fun  getOrder() : Order? {

        return null
    }

}

 interface RetroFitInterface {
     @GET("")
     fun getMenu()
             : Call<List<Item>>

     fun setOrder()

     @GET("")
     fun getOrder() : Call<Order>
 }