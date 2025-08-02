package com.example.dailyqwiz.domain.usecases.database

import com.example.dailyqwiz.domain.repository.QuizDbRepository
import javax.inject.Inject

class DeleteQuizUseCase @Inject constructor(
    private val repository: QuizDbRepository
) {
    suspend operator fun invoke(quizId: Int) = repository.deleteQuiz(quizId)
}
