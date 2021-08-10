package com.khaled.taager.ui.allproducts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.khaled.taager.data.model.ProductItem
import com.khaled.taager.databinding.AdapterProductListItemBinding
import com.khaled.taager.utils.OnPositionClicked

class CustomViewHolder(private val listener: OnPositionClicked, val binding: ViewBinding) :
    RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener {
                listener.onClick(adapterPosition)
            }
        }
    }

class ProductAdapter(private val listener: OnPositionClicked) :
    ListAdapter<ProductItem, CustomViewHolder>(Companion) {
    companion object : DiffUtil.ItemCallback<ProductItem>() {
        override fun areItemsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean =
            oldItem == newItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterProductListItemBinding.inflate(inflater, parent, false)
        return CustomViewHolder(listener, binding)

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val currentProduct = getItem(position)
        val itemBinding = holder.binding as AdapterProductListItemBinding
        itemBinding.product = currentProduct
    }
}