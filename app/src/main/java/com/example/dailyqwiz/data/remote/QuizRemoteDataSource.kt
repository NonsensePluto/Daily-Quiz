package com.example.dailyqwiz.data.remote

import com.example.dailyqwiz.data.remote.model.QuizQuestionResponse
import javax.inject.Inject

class QuizRemoteDataSource @Inject constructor(
    private val quizApiService: QuizApiService
) {
    suspend fun getQuestions(
        amount: Int = 5,
        category: Int? = null,
        difficulty: String? = null,
        type: String? = null
    ): List<QuizQuestionResponse> = quizApiService.getQuestions(amount, category, difficulty, type).results
}