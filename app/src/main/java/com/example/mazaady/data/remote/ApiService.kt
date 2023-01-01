package com.example.mazaady.data.remote

import com.example.mazaady.data.remote.entity.CategoriesData
import com.example.mazaady.data.remote.entity.PropertyRemote
import com.example.mazaady.data.remote.entity.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface ApiService {

    @Headers("Accept-Language: en-US")
    @GET("properties")
    suspend fun getCategoryProps(@Query("cat") categoryId: String): Response<ResponseBody<ArrayList<PropertyRemote>>>

    @Headers("Accept-Language: en-US")
    @GET("get_all_cats")
    suspend fun getAllCategories(): Response<ResponseBody<CategoriesData>>
}