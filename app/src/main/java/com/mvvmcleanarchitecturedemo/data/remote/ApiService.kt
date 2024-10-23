package com.mvvmcleanarchitecturedemo.data.remote

import com.mvvmcleanarchitecturedemo.data.model.MealResponse
import com.mvvmcleanarchitecturedemo.domain.model.MealDetailsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search.php")
    suspend fun getMeal(
        @Query("s") s: String
    ): MealResponse

    @GET("lookup.php")
    suspend fun getMealDetails(
        @Query("i") i: String
    ): MealResponse

}