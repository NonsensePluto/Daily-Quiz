package com.example.dailyqwiz.domain.usecases.database

import com.example.dailyqwiz.domain.model.QuizHistory
import com.example.dailyqwiz.domain.repository.QuizRepository
import javax.inject.Inject

class GetQuizByIdUseCase @Inject constructor(
    private val quizRepository: QuizRepository
) {
    suspend operator fun invoke(quizId: Int): QuizHistory? = quizRepository.getQuizById(quizId)
}