package com.android.dubizzle.presentation.fragment

import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.android.dubizzle.domain.model.Response
import com.android.dubizzle.presentation.activity.BaseActivity
import com.android.dubizzle.presentation.activity.DubizzleActivity

/**
 *   Created by Mohd Farhan on 22/01/2021.
 */
abstract class BaseFragment : Fragment() , View.OnClickListener{

    var loaderView : View? = null;

    fun showResult(result: Response<Any>) {
        when(result) {
            is Response.Success -> {
                loader(false)
                populateUi(result.data)
            }
            is Response.Error -> {
                showSnackBar(result.error)
                loader(false)
            }
            is Response.Loading -> {
                loader(true)
            }
        }
    }

    open fun populateUi(result: Any){

    }


    fun loader(show: Boolean){
        if(show)
            loaderView?.visibility = View.VISIBLE
        else
            loaderView?.visibility = View.GONE
    }



    fun showSnackBar(message: String){
        (activity as BaseActivity).showSnackBar(message)
    }


    public fun getNavController() : NavController?{
        return (activity as DubizzleActivity).getNavController()
    }


}