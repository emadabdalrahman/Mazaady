package com.example.mazaady.data.remote.data_source

import com.example.mazaady.data.remote.entity.CategoriesData
import com.example.mazaady.data.remote.entity.PropertyRemote
import com.example.mazaady.data.remote.entity.ResponseBody
import retrofit2.Response

interface CategoryRemoteSource {

    suspend fun getCategoryProps(categoryId: String): Response<ResponseBody<ArrayList<PropertyRemote>>>

    suspend fun getAllCategories(): Response<ResponseBody<CategoriesData>>
}