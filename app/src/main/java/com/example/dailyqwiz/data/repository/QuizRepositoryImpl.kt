package com.example.dailyqwiz.data.repository

import com.example.dailyqwiz.data.database.dao.QuizDao
import com.example.dailyqwiz.domain.mapper.QuizDbToDomain
import com.example.dailyqwiz.domain.mapper.QuizDomainToDb
import com.example.dailyqwiz.domain.mapper.UserAnswersDomainToDb
import com.example.dailyqwiz.domain.model.QuizHistory
import com.example.dailyqwiz.domain.model.UserAnswer
import com.example.dailyqwiz.domain.repository.QuizRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class QuizRepositoryImpl @Inject constructor(
    private val quizDao: QuizDao,
    private val quizDbToDomain: QuizDbToDomain,
    private val quizDomainToDb: QuizDomainToDb,
    private val userAnswersDomainToDb: UserAnswersDomainToDb
) : QuizRepository {

    override suspend fun saveQuiz(userAnswers: List<UserAnswer>, points: Int) {
        val quizNumber = quizDao.getCountOfQuizzes() + 1
        val title = "Quiz $quizNumber"
        val quizEntity = quizDomainToDb(title, points)
        val quizId = quizDao.insertQuiz(quizEntity).toInt()

        userAnswers.forEach { userAnswer ->
            val entity = userAnswersDomainToDb(userAnswer, quizId)
            quizDao.insertAnswer(entity)
        }
    }

    override fun getCountOfQuizzes(): Int = quizDao.getCountOfQuizzes()

    override suspend fun getQuizById(quizId: Int): QuizHistory? {
        return quizDao.getQuizById(quizDao.getCountOfQuizzes())?.let { quiz ->
            val userAnswers = quizDao.getUserAnswersForQuiz(quiz.id)
            quizDbToDomain(quiz, userAnswers)
        }
    }

    override fun getAllHistory(): Flow<List<QuizHistory>> {
        return quizDao.getAllQuizzes().map { quizList ->
            quizList.map { quiz ->
                val userAnswers = quizDao.getUserAnswersForQuiz(quiz.id)
                quizDbToDomain(quiz, userAnswers)
            }
        }
    }

    override suspend fun getQuizHistory(quizId: Int): QuizHistory? {
        val quiz = quizDao.getQuizById(quizId) ?: return null
        val answers = quizDao.getUserAnswersForQuiz(quizId)
        return quizDbToDomain(quiz, answers)
    }

    override suspend fun deleteQuiz(quizId: Int) {
        val quiz = quizDao.getQuizById(quizId) ?: return
        quizDao.deleteQuiz(quiz)
        quizDao.deleteUserAnswersForQuiz(quizId)
    }
}