package com.example.dailyqwiz.domain.model


data class QuizHistory(
    val id: Int = 0,
    val title: String,
    val date: Long,
    val time: Long,
    val points: Int = 0,
    val userAnswers: List<UserAnswersHistory> = emptyList()
)