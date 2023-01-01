package com.example.mazaady.data.remote.entity

import com.example.mazaady.domain.model.Category
import com.google.gson.annotations.SerializedName

data class CategoryRemote(
    @SerializedName("id") var id: Int,
    @SerializedName("name") var name: String,
    @SerializedName("description") var description: String? = null,
    @SerializedName("image") var image: String,
    @SerializedName("slug") var slug: String? = null,
    @SerializedName("children") var children: List<CategoryRemote>? = listOf(),
    @SerializedName("circle_icon") var circleIcon: String,
    @SerializedName("disable_shipping") var disableShipping: Int
)

fun List<CategoryRemote>.mapToModel(): List<Category> = map { it.mapToModel() }

fun CategoryRemote.mapToModel(): Category {
    return Category(id, name, children?.mapToModel() ?: emptyList())
}