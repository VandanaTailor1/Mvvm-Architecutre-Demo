package com.mvvmcleanarchitecturedemo.utils

import android.provider.ContactsContract.Data
import com.mvvmcleanarchitecturedemo.data.model.MealResponse

sealed class ApiResponseCallBack<T> {

    class Failed<T>(val message: String) : ApiResponseCallBack<T>()
    class Success<T>(val data : T) : ApiResponseCallBack<T>()
    class Loading<T> : ApiResponseCallBack<T>()

    companion object {
        fun <T> loading() = Loading<T>()
        fun <T> success(data: T) = Success(data)
        fun <T> failed(message: String) = Failed<T>(message)
    }

}