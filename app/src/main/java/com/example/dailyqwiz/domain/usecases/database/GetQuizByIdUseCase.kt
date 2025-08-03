package com.example.dailyqwiz.domain.usecases.database

import com.example.dailyqwiz.domain.repository.QuizDbRepository
import javax.inject.Inject

class GetQuizByIdUseCase @Inject constructor(
    private val quizRepository: QuizDbRepository
) {
    suspend operator fun invoke(quizId: Int) = quizRepository.getQuizById(quizId)
}