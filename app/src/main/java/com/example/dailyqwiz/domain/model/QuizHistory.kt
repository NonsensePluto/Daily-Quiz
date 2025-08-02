package com.example.dailyqwiz.domain.model


data class QuizHistory(
    val title: String,
    val date: Long,
    val time: Long,
    val historyState: QuizHistoryState
)