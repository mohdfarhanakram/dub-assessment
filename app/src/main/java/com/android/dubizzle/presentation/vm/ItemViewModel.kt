package com.android.dubizzle.presentation.vm

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.android.dubizzle.data.remote.ApiError
import com.android.dubizzle.domain.model.ItemInfo
import com.android.dubizzle.domain.model.Response
import com.android.dubizzle.domain.usecase.ItemsUseCase
import com.android.dubizzle.domain.usecase.base.UseCaseResponse

/**
 *   Created by Mohd Farhan on 22/01/2021.
 */
class ItemViewModel @ViewModelInject constructor(
    private val itemUseCase : ItemsUseCase,
    @Assisted private val savedStateHandle: SavedStateHandle
): BaseVM()
{

    private lateinit var mResult: ItemInfo

    fun fetchItemList() {

        if(this::mResult.isInitialized){
            return
        }

        liveData.postValue(Response.Loading)

        itemUseCase.invoke(viewModelScope, null, object : UseCaseResponse<ItemInfo> {
            override fun onSuccess(result: ItemInfo) {
                mResult = result;
                liveData.postValue(Response.Success(result))
            }

            override fun onError(apiError: ApiError?) {
                liveData.postValue(apiError?.getErrorMessage()?.let { Response.Error(it) })
            }
        },
        )
    }

}