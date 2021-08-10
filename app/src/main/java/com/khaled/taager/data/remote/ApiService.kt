package com.khaled.taager.data.remote

import com.khaled.taager.data.model.ProductItem
import retrofit2.http.GET

interface ApiService {

    companion object {
        const val BASE_URL = "https://607ee45b02a23c0017e8c510.mockapi.io/"
    }

    @GET("/taager/api/interview/products")
    suspend fun getAllProducts(): List<ProductItem>

}