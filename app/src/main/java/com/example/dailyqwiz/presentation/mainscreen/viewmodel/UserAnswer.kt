package com.example.dailyqwiz.presentation.mainscreen.viewmodel

import com.example.dailyqwiz.domain.model.QuizQuestionModel

data class UserAnswer(
    val question: QuizQuestionModel,
    val selected: String
)
