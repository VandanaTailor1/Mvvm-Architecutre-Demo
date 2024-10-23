package com.mvvmcleanarchitecturedemo.data.repository

import com.mvvmcleanarchitecturedemo.data.model.MealResponse
import com.mvvmcleanarchitecturedemo.data.remote.ApiService
import com.mvvmcleanarchitecturedemo.domain.repository.MealSearchRepository

class GetMealListImpl(private val apiService: ApiService) : MealSearchRepository {

    override suspend fun getMealList(s: String) : MealResponse {
             return apiService.getMeal(s)
    }
}