package com.example.dailyqwiz.domain.mapper

import com.example.dailyqwiz.data.database.entity.QuizEntity
import com.example.dailyqwiz.data.database.entity.UserAnswersEntity
import com.example.dailyqwiz.domain.model.QuizHistory
import com.example.dailyqwiz.domain.model.QuizHistoryState
import javax.inject.Inject

class QuizDbToDomain @Inject constructor(
    private val userAnswersDbToDomain: UserAnswersDbToDomain
) {
    operator fun invoke(quizEntity: QuizEntity, userAnswers: List<UserAnswersEntity>): QuizHistory {
        return QuizHistory(
            title = quizEntity.title,
            date = quizEntity.date,
            time = quizEntity.time,
            historyState = QuizHistoryState(
                userAnswers = userAnswers.map { answer ->
                    userAnswersDbToDomain(answer)
                },
                points = userAnswers.count { it.selected == it.correctAnswer }
            )
        )
    }
}