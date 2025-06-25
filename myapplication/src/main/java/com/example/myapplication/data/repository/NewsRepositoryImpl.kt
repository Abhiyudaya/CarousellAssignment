package com.example.myapplication.data.repository

import com.example.myapplication.data.network.ApiService
import com.example.myapplication.data.network.Result
import com.example.myapplication.data.network.model.NewsNetwork
import com.example.myapplication.utils.safeApiCall
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : NewsRepository {

    override suspend fun getListNews(): Result<List<NewsNetwork>> {
        return try {
            val result = safeApiCall { apiService.getListNews() }
            if (result is Result.Success) {
                val data = result.data
                Result.Success(data)
            } else {
                Result.Success(emptyList())
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}