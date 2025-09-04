package com.example.dailyqwiz.domain.usecases.database

import com.example.dailyqwiz.domain.model.QuizHistory
import com.example.dailyqwiz.domain.repository.QuizRepository
import javax.inject.Inject

class GetQuizHistoryUseCase @Inject constructor(
    private val repository: QuizRepository
) {
    suspend operator fun invoke(quizId: Int): QuizHistory? = repository.getQuizHistory(quizId)
}
