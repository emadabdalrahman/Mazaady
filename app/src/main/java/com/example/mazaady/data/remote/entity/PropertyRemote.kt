package com.example.mazaady.data.remote.entity

import com.example.mazaady.domain.model.Property
import com.google.gson.annotations.SerializedName

data class PropertyRemote(
    @SerializedName("id") var id: Int,
    @SerializedName("name") var name: String,
    @SerializedName("description") var description: String,
    @SerializedName("slug") var slug: String,
    @SerializedName("parent") var parent: Int? = null,
    @SerializedName("list") var list: Boolean,
    @SerializedName("type") var type: String? = null,
    @SerializedName("value") var value: String,
    @SerializedName("other_value") var otherValue: String? = null,
    @SerializedName("options") var options: List<OptionRemote> = listOf()
)

fun List<PropertyRemote>.mapToModel() = map { it.mapToModel() }

fun PropertyRemote.mapToModel(): Property {
    return Property(id, name, options.mapToModel())
}