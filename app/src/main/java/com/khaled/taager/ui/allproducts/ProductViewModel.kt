package com.khaled.taager.ui.allproducts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.khaled.taager.data.ProductRepository
import com.khaled.taager.data.model.ProductItem
import com.khaled.taager.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel(){

    fun getAllProducts()= liveData(Dispatchers.IO) {
        emit(Resource.Loading)
        try {
            val data = productRepository.getAllProducts()
            emit(Resource.Success(data))
        }catch (e: Exception){
            emit(Resource.Error(message = e.localizedMessage ?: "Error occured, Please try again later"))
        }
    }
}