package com.three_squared.qc_online

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

class MenuScreenRepository {

    private val retroFit : Retrofit by lazy {
        Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create())
            .baseUrl("https://api.github.com/").build()
    }

    suspend fun getMenu() : List<Item> {
        val retrofitInterface = retroFit.create(MenuInterface::class.java)

        val response = retrofitInterface.getMenu().awaitResponse()

        if (response.isSuccessful) {
            return if (response.body() != null) {
                response.body()!!
            } else {
                listOf<Item>()
            }
        } else {
            return listOf()
        }
    }


}

interface MenuInterface {
    @GET("")
    fun getMenu()
            : Call<List<Item>>
}