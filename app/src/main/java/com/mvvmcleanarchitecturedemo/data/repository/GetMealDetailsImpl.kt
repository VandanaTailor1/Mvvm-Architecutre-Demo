package com.mvvmcleanarchitecturedemo.data.repository

import com.mvvmcleanarchitecturedemo.data.model.MealResponse
import com.mvvmcleanarchitecturedemo.data.remote.ApiService
import com.mvvmcleanarchitecturedemo.domain.repository.GetMealDetailsRepository

class GetMealDetailsImpl(private val apiService: ApiService) : GetMealDetailsRepository {

    override suspend fun getMealDetails(id: String): MealResponse {
       return apiService.getMealDetails(id)
    }

}