package com.example.dailyqwiz.presentation.mainscreen.viewmodel

import com.example.dailyqwiz.domain.model.QuizQuestionModel

data class MainScreenState(
    val questions: List<QuizQuestionModel> = emptyList(),
    val userAnswers: List<UserAnswer> = emptyList(),
    val points: Int = 0,
    val currentShuffledAnswers: List<String> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)