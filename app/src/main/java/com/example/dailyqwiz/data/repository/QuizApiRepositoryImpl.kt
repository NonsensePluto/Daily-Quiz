package com.example.dailyqwiz.data.repository

import com.example.dailyqwiz.data.remote.QuizRemoteDataSource
import com.example.dailyqwiz.domain.mapper.QuizQuestionResponseToDomain
import com.example.dailyqwiz.domain.model.QuizQuestionModel
import com.example.dailyqwiz.domain.repository.QuizApiRepository
import javax.inject.Inject

class QuizApiRepositoryImpl @Inject constructor(
    private val quizRemoteDataSource: QuizRemoteDataSource,
    private val responseToModelMapper: QuizQuestionResponseToDomain
) : QuizApiRepository {

    override suspend fun getQuizQuestions(
        amount: Int,
        category: Int?,
        difficulty: String?,
        type: String?
    ): List<QuizQuestionModel> {
        return quizRemoteDataSource.getQuestions(amount, category, difficulty, type)
            .map { question ->
                responseToModelMapper(question)
            }
    }
}