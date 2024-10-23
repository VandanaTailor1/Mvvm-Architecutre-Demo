    package com.mvvmcleanarchitecturedemo.domain.repository

    import com.mvvmcleanarchitecturedemo.data.model.MealResponse

    interface MealSearchRepository {

        suspend fun getMealList(s : String) : MealResponse

    }