package com.example.dailyqwiz.domain.usecases

import com.example.dailyqwiz.domain.repository.QuizRepository
import javax.inject.Inject

class GetQuizQuestionsUseCase @Inject constructor(
    private val repository: QuizRepository
) {
    suspend operator fun invoke(
        amount: Int = 5,
        category: Int? = null,
        difficulty: String? = null,
        type: String? = null
    ) = repository.getQuizQuestions(amount, category, difficulty, type)
}