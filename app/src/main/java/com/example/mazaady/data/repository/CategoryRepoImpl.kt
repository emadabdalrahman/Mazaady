package com.example.mazaady.data.repository

import android.util.Log
import com.example.mazaady.data.remote.data_source.CategoryRemoteSource
import com.example.mazaady.data.remote.entity.CategoryRemote
import com.example.mazaady.data.remote.entity.PropertyRemote
import com.example.mazaady.utils.tag
import javax.inject.Inject

class CategoryRepoImpl @Inject constructor(
    private val remoteSource: CategoryRemoteSource
) : CategoryRepo {

    override suspend fun getCategoryProps(categoryId: String): List<PropertyRemote> {
        kotlin.runCatching {
            val response = remoteSource.getCategoryProps(categoryId)
            if (response.isSuccessful) {
                return response.body()?.data ?: emptyList()
            }
        }.onFailure { Log.e(tag(), it.toString()) }
        return emptyList()
    }

    override suspend fun getAllCategories(): List<CategoryRemote> {
        kotlin.runCatching {
            val response = remoteSource.getAllCategories()
            if (response.isSuccessful) {
                return response.body()?.data?.categories ?: emptyList()
            }
        }.onFailure {
            Log.e(tag(), it.toString())
        }
        return emptyList()
    }

}