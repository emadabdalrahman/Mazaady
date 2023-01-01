package com.example.mazaady.domain.use_case

import com.example.mazaady.data.remote.entity.mapToModel
import com.example.mazaady.data.repository.CategoryRepo
import com.example.mazaady.domain.model.Category
import com.example.mazaady.domain.model.Property
import javax.inject.Inject

class FormUseCase @Inject constructor(private val categoryRepo: CategoryRepo) {
    suspend fun getCategoryProps(categoryId: String): List<Property> {
        return categoryRepo.getCategoryProps(categoryId).mapToModel()
    }

    suspend fun getAllCategories(): List<Category> {
        return categoryRepo.getAllCategories().mapToModel()
    }
}