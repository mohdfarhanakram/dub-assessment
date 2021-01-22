package com.android.dubizzle.data.repository

import com.android.dubizzle.domain.model.ItemInfo

/**
 *   Created by Mohd Farhan on 22/01/2021.
 */
interface IRepository {
    suspend fun getItems(): ItemInfo
}