package com.example.dailyqwiz.presentation.viewmodels.historyscreen

import com.example.dailyqwiz.domain.model.QuizHistory

data class HistoryState (
    val isLoading: Boolean = false,
    val historyList: List<QuizHistory> = emptyList(),
    val selectedQuiz: QuizHistory? = null,
    val error: String = "Не удалось загрузить историю"
)