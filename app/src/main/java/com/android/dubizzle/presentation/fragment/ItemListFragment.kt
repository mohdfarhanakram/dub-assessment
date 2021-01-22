package com.android.dubizzle.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.annotation.Nullable
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.android.dubizzle.R
import com.android.dubizzle.databinding.FragmentItemListBinding
import com.android.dubizzle.domain.model.Item
import com.android.dubizzle.domain.model.ItemInfo
import com.android.dubizzle.presentation.adapter.ItemAdapter
import com.android.dubizzle.presentation.vm.ItemViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 *   Created by Mohd Farhan on 22/01/2021.
 */
@AndroidEntryPoint
class ItemListFragment : BaseFragment() {

    private val itemsViewModel: ItemViewModel by viewModels()
    private var binding : FragmentItemListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentItemListBinding.inflate(inflater, container, false)
        loaderView = binding?.loading;
        return binding?.root;
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.itemRv?.layoutManager = GridLayoutManager(requireContext(), 2)

        itemsViewModel.responseLiveData().observe(viewLifecycleOwner, Observer { showResult(it) })
        itemsViewModel.fetchItemList()
    }


    override fun populateUi(result: Any) {
        when(result){
            is ItemInfo -> {
                binding?.itemRv?.adapter = ItemAdapter(
                    result.items,
                    this
                );
                return
            }
            is String -> {
                showSnackBar(result as String)
                return
            }
            else -> {
                showSnackBar(getString(R.string.default_error_msg))
                return
            }
        }
    }

    override fun onClick(view: View?) {
        //val item = view?.tag as Item
    }

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true /* enabled by default */) {
                override fun handleOnBackPressed() {
                    requireActivity().finish()
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)

    }

}