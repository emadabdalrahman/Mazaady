package com.example.mazaady.data.repository

import com.example.mazaady.data.remote.entity.CategoryRemote
import com.example.mazaady.data.remote.entity.PropertyRemote

interface CategoryRepo {
    suspend fun getCategoryProps(categoryId: String): List<PropertyRemote>

    suspend fun getAllCategories(): List<CategoryRemote>
}