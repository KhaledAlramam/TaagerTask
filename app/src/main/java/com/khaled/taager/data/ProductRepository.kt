package com.khaled.taager.data

import com.khaled.taager.data.remote.ApiService
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getAllProducts()=
        apiService.getAllProducts()
}