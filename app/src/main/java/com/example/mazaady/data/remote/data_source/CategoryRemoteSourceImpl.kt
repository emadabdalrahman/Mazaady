package com.example.mazaady.data.remote.data_source

import com.example.mazaady.data.remote.ApiService
import com.example.mazaady.data.remote.entity.CategoriesData
import com.example.mazaady.data.remote.entity.PropertyRemote
import com.example.mazaady.data.remote.entity.ResponseBody
import retrofit2.Response
import javax.inject.Inject


class CategoryRemoteSourceImpl @Inject constructor(private val client: ApiService) :
    CategoryRemoteSource {

    override suspend fun getCategoryProps(categoryId: String): Response<ResponseBody<ArrayList<PropertyRemote>>> {
        return client.getCategoryProps(categoryId)
    }

    override suspend fun getAllCategories(): Response<ResponseBody<CategoriesData>> {
        return client.getAllCategories()
    }

}