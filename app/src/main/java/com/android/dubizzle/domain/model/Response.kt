package com.android.dubizzle.domain.model

/**
 *   Created by Mohd Farhan on 22/01/2021.
 */

sealed class Response<out T : Any> {
    data class Success<out T : Any>(val data: T) : Response<T>()
    data class Error(val error: String) : Response<Nothing>()
    object Loading : Response<Nothing>()
}