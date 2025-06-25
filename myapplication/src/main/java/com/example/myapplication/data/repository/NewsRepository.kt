package com.example.myapplication.data.repository

import com.example.myapplication.data.network.Result
import com.example.myapplication.data.network.model.NewsNetwork

interface NewsRepository {
    suspend fun getListNews(): Result<List<NewsNetwork>>
}