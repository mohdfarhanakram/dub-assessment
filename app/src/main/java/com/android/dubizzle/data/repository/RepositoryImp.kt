package com.android.dubizzle.data.repository

import com.android.dubizzle.domain.model.ItemInfo
import javax.inject.Inject

/**
 *   Created by Mohd Farhan on 22/01/2021.
 */
class RepositoryImp @Inject constructor (
    private val repoFactory: RepoFactory
) : IRepository{

    override suspend fun getItems(): ItemInfo {
        return repoFactory.apiService.getItems()
    }
}