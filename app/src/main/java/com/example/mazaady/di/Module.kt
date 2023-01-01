package com.example.mazaady.di

import com.example.mazaady.BuildConfig
import com.example.mazaady.data.remote.ApiService
import com.example.mazaady.data.remote.data_source.CategoryRemoteSource
import com.example.mazaady.data.remote.data_source.CategoryRemoteSourceImpl
import com.example.mazaady.data.repository.CategoryRepo
import com.example.mazaady.data.repository.CategoryRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideCategoryRemoteSource(source: CategoryRemoteSourceImpl): CategoryRemoteSource = source

    @Singleton
    @Provides
    fun provideCategoryRepo(repo: CategoryRepoImpl): CategoryRepo = repo

}