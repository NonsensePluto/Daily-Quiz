package com.example.dailyqwiz.domain.repository

import com.example.dailyqwiz.domain.model.QuizHistory
import com.example.dailyqwiz.domain.model.UserAnswer
import kotlinx.coroutines.flow.Flow

interface QuizRepository {
    suspend fun saveQuiz(userAnswers: List<UserAnswer>, points: Int)
    suspend fun getQuizById(quizId: Int): QuizHistory?
    fun getAllHistory(): Flow<List<QuizHistory>>
    suspend fun getQuizHistory(quizId: Int): QuizHistory?
    suspend fun deleteQuiz(quizId: Int)
    fun getCountOfQuizzes(): Int
}