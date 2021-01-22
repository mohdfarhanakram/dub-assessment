package com.android.dubizzle.presentation.vm

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.dubizzle.domain.model.Response
import kotlinx.coroutines.cancel

/**
 *   Created by Mohd Farhan on 22/01/2021.
 */
open class BaseVM : ViewModel() , LifecycleObserver {

    val liveData = MutableLiveData<Response<Any>>()

    fun responseLiveData() : MutableLiveData<Response<Any>> {
        return liveData
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }
}