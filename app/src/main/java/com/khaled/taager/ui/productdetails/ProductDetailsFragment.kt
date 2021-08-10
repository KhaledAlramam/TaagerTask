package com.khaled.taager.ui.productdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.khaled.taager.R
import com.khaled.taager.databinding.FragmentItemDetailsBinding
import com.khaled.taager.databinding.FragmentItemsBinding

class ProductDetailsFragment : Fragment(R.layout.fragment_item_details) {

    private val args: ProductDetailsFragmentArgs by navArgs()
    private var _binding: FragmentItemDetailsBinding? = null
    private val binding
        get() =
            _binding!!



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentItemDetailsBinding.bind(view)
        val product = args.product
        binding.product = product

    }
}