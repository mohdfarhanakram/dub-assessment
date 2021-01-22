package com.android.dubizzle.domain.model

import com.google.gson.annotations.SerializedName

/**
 *   Created by Mohd Farhan on 22/01/2021.
 */
data class ItemInfo (
    @SerializedName("results") val items : List<Item>
)