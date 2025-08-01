package com.example.dailyqwiz.presentation.mainscreen

import com.example.dailyqwiz.domain.model.QuizQuestionModel

data class UserAnswer(
    val question: QuizQuestionModel,
    val selected: String
)

data class MainScreenState(
    val questions: List<QuizQuestionModel> = emptyList(),
    val userAnswers: List<UserAnswer> = emptyList(),
    val points: Int = 0,
    val isLoading: Boolean = false,
    val error: String? = null
)