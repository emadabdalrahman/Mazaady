package com.example.mazaady.data.remote.entity

import com.google.gson.annotations.SerializedName

data class CategoriesData(
    @SerializedName("categories") var categories: List<CategoryRemote>,
)