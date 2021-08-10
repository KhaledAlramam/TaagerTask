package com.khaled.taager.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductItem(
    val createdAt: Int,
    val id: String,
    val name: String,
    val price: Int
): Parcelable