package com.example.myapplication.data.network

import com.example.myapplication.data.network.model.NewsNetwork
import retrofit2.http.GET

interface ApiService {

    @GET("carousell_news.json")
    suspend fun getListNews(): List<NewsNetwork>
}