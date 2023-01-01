package com.example.mazaady.domain.model

data class Property(
    var id: Int,
    var name: String,
    var options: List<Option> = arrayListOf()
)