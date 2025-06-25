package com.example.carousellassignment.presentation.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.data.network.model.NewsNetwork
import com.example.myapplication.utils.NewsFilterType
import kotlinx.coroutines.Job

interface NewsViewModelContract {

    fun getIsLoading(): LiveData<Boolean>

    fun setIsLoading(isLoading: Boolean)

    fun getListNews(): Job

    fun listNewsLiveData(): MutableLiveData<List<NewsNetwork>>

    fun errorListNewsLiveData(): LiveData<String>

    fun setFilterType(filterType: NewsFilterType)
}