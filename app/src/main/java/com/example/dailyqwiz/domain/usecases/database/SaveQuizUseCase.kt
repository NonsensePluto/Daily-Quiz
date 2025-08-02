package com.example.dailyqwiz.domain.usecases.database

import com.example.dailyqwiz.data.database.entity.QuizEntity
import com.example.dailyqwiz.data.database.entity.UserAnswersEntity
import com.example.dailyqwiz.domain.repository.QuizDbRepository
import javax.inject.Inject

class SaveQuizUseCase @Inject constructor(
    private val repository: QuizDbRepository
) {
    suspend operator fun invoke(quiz: QuizEntity, answers: List<UserAnswersEntity>) =
        repository.saveQuiz(quiz, answers)
}
