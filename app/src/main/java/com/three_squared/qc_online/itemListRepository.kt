package com.three_squared.qc_online

class itemListRepository {

    suspend fun getMenu() : List<Item> {
        /*val retrofitInterface = retroFit.create(RetroFitInterface::class.java)

        val response = retrofitInterface.getMenu().awaitResponse()

        if (response.isSuccessful) {
            return if (response.body() != null) {
                response.body()!!
            } else {
                listOf<Item>()
            }
        } else {
            return listOf()
        }*/

        return mockBagels()
    }

    fun mockBagels() : List<Item> {
        var bagels : MutableList<Item> = mutableListOf()

        bagels.add(
            Item(
                id = "1",
                name = "ham bagel",
                price = 2.50,
                description = "bagel with ham",
                inStock = true,
                kind = "bagel"
            ))


        bagels.add(
            Item(
                id = "2",
                name = "egg bagel",
                price = 12.50,
                description = "bagel",
                inStock = true,
                kind = "bagel"
            ))

        bagels.add(
            Item(
                id = "3",
                name = "bagel 3",
                price = 12.50,
                description = "bagel",
                inStock = true,
                kind = "bagel"
            ))

        bagels.add(
            Item(
                id = "4",
                name = "bagel 4",
                price = 12.50,
                description = "bagel",
                inStock = true,
                kind = "bagel"
            ))

        return bagels
    }
}