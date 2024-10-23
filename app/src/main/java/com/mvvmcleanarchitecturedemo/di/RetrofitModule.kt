package com.mvvmcleanarchitecturedemo.di

import com.mvvmcleanarchitecturedemo.data.remote.ApiService
import com.mvvmcleanarchitecturedemo.data.repository.GetMealDetailsImpl
import com.mvvmcleanarchitecturedemo.data.repository.GetMealListImpl
import com.mvvmcleanarchitecturedemo.domain.repository.GetMealDetailsRepository
import com.mvvmcleanarchitecturedemo.domain.repository.MealSearchRepository
import com.mvvmcleanarchitecturedemo.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object RetrofitModule {

    @Provides
    @Singleton
    fun provideMealSearchApi() : ApiService {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    fun provideMealSearchRepository(apiService: ApiService) : MealSearchRepository {
        return GetMealListImpl(apiService)
    }

    @Provides
    fun provideMealDetailsRepository(apiService: ApiService) : GetMealDetailsRepository {
        return GetMealDetailsImpl(apiService)
    }
}
