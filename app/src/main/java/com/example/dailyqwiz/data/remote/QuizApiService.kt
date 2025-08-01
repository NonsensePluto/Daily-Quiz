package com.example.dailyqwiz.data.remote

import com.example.dailyqwiz.data.remote.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface QuizApiService {
    @GET("api.php")
    suspend fun getQuestions(
        @Query("amount") amount: Int,
        @Query("category") category: Int? = null,
        @Query("difficulty") difficulty: String? = null,
        @Query("type") type: String? = null
    ): ApiResponse
}