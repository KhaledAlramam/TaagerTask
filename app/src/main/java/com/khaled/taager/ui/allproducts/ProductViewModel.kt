package com.khaled.taager.ui.allproducts

import androidx.lifecycle.ViewModel
import com.khaled.taager.data.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel(){

}