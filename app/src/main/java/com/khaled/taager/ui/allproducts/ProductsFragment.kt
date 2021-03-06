package com.khaled.taager.ui.allproducts

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.khaled.taager.R
import com.khaled.taager.data.model.ProductItem
import com.khaled.taager.databinding.FragmentItemsBinding
import com.khaled.taager.utils.OnPositionClicked
import com.khaled.taager.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsFragment : Fragment(R.layout.fragment_items), OnPositionClicked {

    private var productAdapter = ProductAdapter(this)
    private val viewModel by viewModels<ProductViewModel>()

    private var _binding: FragmentItemsBinding? = null
    private val binding
        get() =
            _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentItemsBinding.bind(view)
        initUi()
        getAllProducts()
    }

    private fun initUi() {
        binding.apply {
            productRv.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            productRv.adapter = productAdapter
            productRv.setHasFixedSize(true)
        }
    }

    /**
     * According to use cause we are loading data each time fragment is created
     * on the other hand, we can cache them in the activity viewModel
     * and get them with Shared ViewModel between fragment and activity
     * using activityViewModels
     * */
    private fun getAllProducts() {
        viewModel.getAllProducts().observe(viewLifecycleOwner) { resources ->
            when (resources) {
                is Resource.Error -> {
                    hideLoading()
                    showError(resources.message)
                }
                Resource.Loading -> showLoading()
                is Resource.Success -> {
                    hideLoading()
                    handleResponse(resources.data)
                }
            }
        }
    }

    private fun handleResponse(response: List<ProductItem>) {
        productAdapter.submitList(response)
    }

    private fun showLoading() {
        binding.progressBar.isVisible = true
    }

    private fun hideLoading() {
        binding.progressBar.isVisible = false
    }

    private fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun onClick(position: Int) {
        val currentProduct = productAdapter.currentList[position]
        val action = ProductsFragmentDirections
            .actionItemsFragmentToItemDetailsFragment(currentProduct)
        findNavController().navigate(action)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}