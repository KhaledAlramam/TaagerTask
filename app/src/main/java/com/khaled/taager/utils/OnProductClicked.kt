package com.khaled.taager.utils

import com.khaled.taager.data.model.ProductItem

interface OnProductClicked {
    fun onClick(product: ProductItem)
}