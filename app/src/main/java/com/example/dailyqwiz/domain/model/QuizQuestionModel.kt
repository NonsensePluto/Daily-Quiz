package com.example.dailyqwiz.domain.model

data class QuizQuestionModel (
    val question: String,
    val correctAnswer: String,
    val incorrectAnswers: List<String>
)
