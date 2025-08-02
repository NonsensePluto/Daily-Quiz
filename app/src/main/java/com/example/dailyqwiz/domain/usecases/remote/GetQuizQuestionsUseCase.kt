package com.example.dailyqwiz.domain.usecases.remote

import com.example.dailyqwiz.domain.repository.QuizRemoteRepository
import javax.inject.Inject

class GetQuizQuestionsUseCase @Inject constructor(
    private val repository: QuizRemoteRepository
) {
    suspend operator fun invoke(
        amount: Int = 5,
        category: Int? = null,
        difficulty: String? = null,
        type: String? = null
    ) = repository.getQuizQuestions(amount, category, difficulty, type)
}