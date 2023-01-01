package com.example.mazaady.data.remote.entity

import com.example.mazaady.domain.model.Option
import com.google.gson.annotations.SerializedName

data class OptionRemote(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("slug") var slug: String? = null,
    @SerializedName("parent") var parent: Int? = null,
    @SerializedName("child") var child: Boolean? = null
)

fun List<OptionRemote>.mapToModel() = map { it.mapToModel() }

fun OptionRemote.mapToModel(): Option {
    return Option(id, name)
}