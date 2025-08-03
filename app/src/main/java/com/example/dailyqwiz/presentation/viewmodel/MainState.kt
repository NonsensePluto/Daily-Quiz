package com.example.dailyqwiz.presentation.viewmodel

import com.example.dailyqwiz.domain.model.QuizQuestionModel
import com.example.dailyqwiz.domain.model.UserAnswer

data class MainState(
    val questions: List<QuizQuestionModel> = emptyList(),
    val userAnswers: List<UserAnswer> = emptyList(),
    val points: Int = 0,
    val currentShuffledAnswers: List<String> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)