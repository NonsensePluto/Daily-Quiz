package com.example.dailyqwiz.domain.repository

import com.example.dailyqwiz.data.database.dao.QuizDao
import com.example.dailyqwiz.data.database.entity.QuizEntity
import com.example.dailyqwiz.data.database.entity.UserAnswersEntity
import com.example.dailyqwiz.domain.mapper.QuizDbToDomain
import com.example.dailyqwiz.domain.model.QuizHistory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class QuizDbRepository @Inject constructor(
    private val quizDao: QuizDao,
    private val quizDbToDomain: QuizDbToDomain
) {

    suspend fun saveQuiz(quiz: QuizEntity, answers: List<UserAnswersEntity>) {
        val quizId = quizDao.insertQuiz(quiz).toInt()
        answers.forEach { answer ->
            quizDao.insertAnswer(answer.copy(idQuiz = quizId))
        }
    }

    fun getAllHistory(): Flow<List<QuizHistory>> {
        return quizDao.getAllQuizzes().map { quizList ->
            quizList.map { quiz ->
                // Загрузка связанных ответов
                val userAnswers = quizDao.getUserAnswersForQuiz(quiz.id)
                quizDbToDomain(quiz, userAnswers)
            }
        }
    }

    suspend fun getQuizHistory(quizId: Int): QuizHistory? {
        val quiz = quizDao.getQuizById(quizId) ?: return null
        val answers = quizDao.getUserAnswersForQuiz(quizId)
        return quizDbToDomain(quiz, answers)
    }

    suspend fun deleteQuiz(quizId: Int) {
        val quiz = quizDao.getQuizById(quizId) ?: return
        quizDao.deleteQuiz(quiz)
        quizDao.deleteUserAnswersForQuiz(quizId)
    }
}