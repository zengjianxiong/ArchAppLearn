package com.zeng.model

import com.google.gson.annotations.SerializedName

data class BaseApiResult<T>(
    @SerializedName("status") val status: Int,
    @SerializedName("msg") val msg: String,
    @SerializedName("data") val data: T
)