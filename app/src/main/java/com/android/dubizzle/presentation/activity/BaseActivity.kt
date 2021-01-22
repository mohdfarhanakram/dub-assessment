package com.android.dubizzle.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

/**
 *   Created by Mohd Farhan on 22/01/2021.
 */
abstract class BaseActivity : AppCompatActivity() {
    fun showSnackBar(message : String){
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show()
    }

}