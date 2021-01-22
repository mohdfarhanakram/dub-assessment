package com.android.dubizzle.data.repository

import com.android.dubizzle.data.remote.ApiService
import javax.inject.Inject

/**
 *   Created by Mohd Farhan on 22/01/2021.
 */
class RepoFactory @Inject constructor (
    private val _apiService: ApiService
){
    val apiService: ApiService get() = _apiService
}