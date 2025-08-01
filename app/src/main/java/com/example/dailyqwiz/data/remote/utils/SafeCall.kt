package com.example.dailyqwiz.data.remote.utils

import retrofit2.Response

sealed interface SafeResult<out T> {
    data class Success<T>(val data: T): SafeResult<T>
    data class Error(val message: String): SafeResult<Nothing>
}

open class SafeApiCall {
    suspend fun <T> safeCall(api: suspend () -> Response<T>): SafeResult<T> {
        return try {
            val response = api()
            val body = response.body()
            if (response.isSuccessful && body != null) {
                SafeResult.Success(body)
            } else {
                SafeResult.Error("${response.code()} ${response.message()}")
            }
        } catch (e: Exception) {
            SafeResult.Error(e.localizedMessage ?: "Unknown error")
        }
    }
}