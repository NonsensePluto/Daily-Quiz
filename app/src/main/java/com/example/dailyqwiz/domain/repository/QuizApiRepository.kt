package com.example.dailyqwiz.domain.repository

import com.example.dailyqwiz.domain.model.QuizQuestionModel

interface QuizApiRepository {
    suspend fun getQuizQuestions(
        amount: Int = 5,
        category: Int? = null,
        difficulty: String? = null,
        type: String? = null
    ): List<QuizQuestionModel>
}