package com.example.dailyqwiz.presentation.viewmodel

import com.example.dailyqwiz.domain.model.QuizQuestionModel

data class UserAnswer(
    val questionText: String,
    val allOptions: List<String>,
    val selected: String,
    val correctAnswer: String
)
