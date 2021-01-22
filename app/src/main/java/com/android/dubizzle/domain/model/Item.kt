package com.android.dubizzle.domain.model

import com.google.gson.annotations.SerializedName

/**
 *   Created by Mohd Farhan on 22/01/2021.
 */
data class Item (
    @SerializedName("created_at") val createdAt : String,
    @SerializedName("price") val price : String,
    @SerializedName("name") val name : String,
    @SerializedName("uid") val uid : String,
    @SerializedName("image_urls") val imageUrls : List<String>
)