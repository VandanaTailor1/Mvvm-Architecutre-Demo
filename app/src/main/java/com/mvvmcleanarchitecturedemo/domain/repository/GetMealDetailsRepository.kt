package com.mvvmcleanarchitecturedemo.domain.repository

import com.mvvmcleanarchitecturedemo.data.model.MealResponse

interface GetMealDetailsRepository {

    suspend fun getMealDetails(id : String) : MealResponse

}