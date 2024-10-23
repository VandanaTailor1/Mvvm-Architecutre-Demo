package com.mvvmcleanarchitecturedemo.domain.usecase

import com.mvvmcleanarchitecturedemo.data.model.MealResponse
import com.mvvmcleanarchitecturedemo.domain.repository.MealSearchRepository
import com.mvvmcleanarchitecturedemo.utils.ApiResponseCallBack
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

import javax.inject.Inject

class GetMealSearchListUseCase @Inject constructor(private val mealSearchRepository: MealSearchRepository) {

    operator fun invoke(s: String) : Flow<ApiResponseCallBack<MealResponse>> =
        flow {
            emit(ApiResponseCallBack.loading())
            emit(ApiResponseCallBack
                .success(
                    mealSearchRepository.getMealList(s))
            )
        } .catch {
            emit(ApiResponseCallBack.failed(it.message.toString()))
        }

}