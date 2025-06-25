package com.example.myapplication.di

import com.example.myapplication.data.network.ApiService
import com.example.myapplication.data.repository.NewsRepository
import com.example.myapplication.data.repository.NewsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(apiService: ApiService) : NewsRepository = NewsRepositoryImpl(apiService)
}