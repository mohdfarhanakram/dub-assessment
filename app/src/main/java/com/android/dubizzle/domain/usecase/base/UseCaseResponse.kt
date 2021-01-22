package com.android.dubizzle.domain.usecase.base

import com.android.dubizzle.data.remote.ApiError

/**
 *   Created by Mohd Farhan on 22/01/2021.
 */
interface UseCaseResponse<Type> {

    fun onSuccess(result: Type)

    fun onError(apiError: ApiError?)
}