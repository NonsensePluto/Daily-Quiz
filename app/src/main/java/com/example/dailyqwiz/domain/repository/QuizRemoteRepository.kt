package com.example.dailyqwiz.domain.repository

import com.example.dailyqwiz.data.remote.QuizRemoteDataSource
import com.example.dailyqwiz.domain.mapper.QuizQuestionResponseToDomain
import com.example.dailyqwiz.domain.model.QuizQuestionModel
import javax.inject.Inject

class QuizRemoteRepository @Inject constructor(
    private val quizRemoteDataSource: QuizRemoteDataSource,
    private val responseToModelMapper: QuizQuestionResponseToDomain
    ) {

    suspend fun getQuizQuestions(
        amount: Int = 5,
        category: Int? = null,
        difficulty: String? = null,
        type: String? = null
    ): List<QuizQuestionModel> {
        return quizRemoteDataSource.getQuestions(amount, category, difficulty, type)
            .map { question ->
                responseToModelMapper(question)
            }
    }
}