package com.example.mazaady.domain.model

data class Category(
    var id: Int,
    var name: String,
    var children: List<Category> = arrayListOf()
)