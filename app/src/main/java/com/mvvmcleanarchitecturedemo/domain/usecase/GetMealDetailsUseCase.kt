package com.mvvmcleanarchitecturedemo.domain.usecase

import com.mvvmcleanarchitecturedemo.data.model.MealResponse
import com.mvvmcleanarchitecturedemo.domain.repository.GetMealDetailsRepository
import com.mvvmcleanarchitecturedemo.domain.repository.MealSearchRepository
import com.mvvmcleanarchitecturedemo.utils.ApiResponseCallBack
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

import javax.inject.Inject

class GetMealDetailsUseCase @Inject constructor(private val getMealDetailsRepository: GetMealDetailsRepository) {

    operator fun invoke(id: String) : Flow<ApiResponseCallBack<MealResponse>> =
        flow {
            emit(ApiResponseCallBack.loading())
            emit(ApiResponseCallBack
                .success(
                    getMealDetailsRepository.getMealDetails(id))
            )
        } .catch {
            emit(ApiResponseCallBack.failed(it.message.toString()))
        }
}