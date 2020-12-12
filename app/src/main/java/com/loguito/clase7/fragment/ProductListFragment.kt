package com.loguito.clase7.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.loguito.clase7.R
import com.loguito.clase7.viewmodels.ProductListViewModel
import kotlinx.android.synthetic.main.fragment_product_list.*

class ProductListFragment : Fragment() {
    val viewModel: ProductListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAllProducts().observe(viewLifecycleOwner) { productList ->
            productQuantityTextView.text = "Cantidad de productos insertados: ${productList.size}"
        }
    }
}