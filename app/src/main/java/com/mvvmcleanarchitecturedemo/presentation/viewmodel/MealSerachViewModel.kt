package com.mvvmcleanarchitecturedemo.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mvvmcleanarchitecturedemo.data.model.MealResponse
import com.mvvmcleanarchitecturedemo.domain.usecase.GetMealSearchListUseCase
import com.mvvmcleanarchitecturedemo.utils.ApiResponseCallBack
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealSearchViewModel @Inject constructor(private val getMealSearchListUseCase: GetMealSearchListUseCase) :
    ViewModel() {

    private val _mealSearch =
        MutableStateFlow<ApiResponseCallBack<MealResponse>>(ApiResponseCallBack.loading())
    val mealSearch: StateFlow<ApiResponseCallBack<MealResponse>> = _mealSearch

     fun searchMeal(s: String) {
        viewModelScope.launch {
            getMealSearchListUseCase.invoke(s).collect {
                _mealSearch.value = it
            }
        }

    }

}