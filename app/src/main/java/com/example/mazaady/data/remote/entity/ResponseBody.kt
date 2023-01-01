package com.example.mazaady.data.remote.entity

import com.google.gson.annotations.SerializedName

data class ResponseBody<T>(
    @SerializedName("code") var code: String,
    @SerializedName("msg") var msg: String,
    @SerializedName("data") var data: T
)