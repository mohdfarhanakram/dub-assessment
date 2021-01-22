package com.android.dubizzle.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.dubizzle.databinding.FragmentItemDetailBinding
import com.android.dubizzle.domain.model.Item
import com.android.dubizzle.utils.setImageUrl
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 *   Created by Mohd Farhan on 22/01/2021.
 */

@AndroidEntryPoint
class ItemDetailFragment : BaseFragment(){

    private var binding : FragmentItemDetailBinding? = null
    private var name : String = ""
    private var price : String = ""
    private var image : String = ""


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentItemDetailBinding.inflate(inflater,container,false)
        arguments?.let {

            name = ItemDetailFragmentArgs.fromBundle(it).name
            price = ItemDetailFragmentArgs.fromBundle(it).price
            image = ItemDetailFragmentArgs.fromBundle(it).image
        }

        return binding?.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.name  = name
        binding?.price  = price
        binding?.itemImg?.setImageUrl(image)
    }

    override fun onClick(p0: View?) {

    }
}