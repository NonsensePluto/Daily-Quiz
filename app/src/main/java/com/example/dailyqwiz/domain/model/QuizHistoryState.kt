package com.example.dailyqwiz.domain.model



data class QuizHistoryState (
    val userAnswers: List<UserAnswersHistory> = emptyList(),
    val points: Int = 0,
)