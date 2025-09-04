package com.example.dailyqwiz.domain.usecases.database

import com.example.dailyqwiz.domain.model.UserAnswer
import com.example.dailyqwiz.domain.repository.QuizRepository
import javax.inject.Inject

class SaveQuizUseCase @Inject constructor(
    private val repository: QuizRepository
) {
    suspend operator fun invoke(userAnswer: List<UserAnswer>, points: Int) =
        repository.saveQuiz(
            userAnswers = userAnswer,
            points = points
        )
}
