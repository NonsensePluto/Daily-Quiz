package com.example.dailyqwiz.domain.usecases.database

import com.example.dailyqwiz.domain.model.QuizHistory
import com.example.dailyqwiz.domain.repository.QuizDbRepository
import javax.inject.Inject

class GetQuizHistoryUseCase @Inject constructor(
    private val repository: QuizDbRepository
) {
    suspend operator fun invoke(quizId: Int): QuizHistory? = repository.getQuizHistory(quizId)
}
