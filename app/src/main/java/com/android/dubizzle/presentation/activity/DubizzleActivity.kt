package com.android.dubizzle.presentation.activity

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.android.dubizzle.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DubizzleActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun getNavController(): NavController? {
        val navHostFragment: NavHostFragment? =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
        return navHostFragment?.getNavController()
    }
}