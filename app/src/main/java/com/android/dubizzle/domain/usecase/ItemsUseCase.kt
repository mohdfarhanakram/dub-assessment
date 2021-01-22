package com.android.dubizzle.domain.usecase

import com.android.dubizzle.data.repository.RepositoryImp
import com.android.dubizzle.domain.model.ItemInfo
import com.android.dubizzle.domain.usecase.base.UseCase
import javax.inject.Inject

/**
 *   Created by Mohd Farhan on 22/01/2021.
 */
class ItemsUseCase @Inject constructor(
    private val repository: RepositoryImp
) : UseCase<ItemInfo, Any?>() {

    override suspend fun run(params: Any? ): ItemInfo {
        return repository.getItems()
    }

}