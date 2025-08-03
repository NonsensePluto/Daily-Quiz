package com.example.dailyqwiz.domain.model

data class UserAnswer(
    val questionText: String,
    val allOptions: List<String>,
    val selected: String,
    val correctAnswer: String
)