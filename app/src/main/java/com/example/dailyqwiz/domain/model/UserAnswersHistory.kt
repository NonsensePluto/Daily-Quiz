package com.example.dailyqwiz.domain.model

data class UserAnswersHistory (
    val questionText: String,
    val allOptions: List<String>,
    val selected: String,
    val correctAnswer: String
)