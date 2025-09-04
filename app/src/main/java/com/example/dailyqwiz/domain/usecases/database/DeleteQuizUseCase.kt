package com.example.dailyqwiz.domain.usecases.database

import com.example.dailyqwiz.domain.repository.QuizRepository
import javax.inject.Inject

class DeleteQuizUseCase @Inject constructor(
    private val repository: QuizRepository
) {
    suspend operator fun invoke(quizId: Int) = repository.deleteQuiz(quizId)
}
