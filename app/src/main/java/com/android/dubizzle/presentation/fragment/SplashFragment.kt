package com.android.dubizzle.presentation.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.dubizzle.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 *   Created by Mohd Farhan on 22/01/2021.
 */
@AndroidEntryPoint
class SplashFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentSplashBinding.inflate(inflater,container,false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            navigateToNext();

        }, 3000)
    }

    override fun onClick(p0: View?) {

    }

    private fun navigateToNext(){
        getNavController()
            ?.navigate(SplashFragmentDirections.actionSplashToItemList())
    }

}