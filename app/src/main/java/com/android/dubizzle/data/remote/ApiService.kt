package com.android.dubizzle.data.remote

import com.android.dubizzle.domain.model.ItemInfo
import retrofit2.http.GET

/**
 *   Created by Mohd Farhan on 22/01/2021.
 */
interface ApiService {

    @GET("default/dynamodb-writer")
    suspend fun getItems(): ItemInfo

}