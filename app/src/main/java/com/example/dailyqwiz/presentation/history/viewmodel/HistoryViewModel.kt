package com.example.dailyqwiz.presentation.history.viewmodel

import androidx.lifecycle.ViewModel
import com.example.dailyqwiz.domain.usecases.database.GetAllQuizHistoryUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import androidx.lifecycle.viewModelScope
import com.example.dailyqwiz.domain.model.QuizHistory
import com.example.dailyqwiz.domain.usecases.database.DeleteQuizUseCase
import com.example.dailyqwiz.domain.utils.DateAndTimeFormatter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val getAllQuizHistoryUseCase: GetAllQuizHistoryUseCase,
    private val getQuizHistoryByIdUseCase: GetAllQuizHistoryUseCase,
    private val deleteQuizUseCase: DeleteQuizUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(HistoryState())
    val uiState: StateFlow<HistoryState> = _uiState.asStateFlow()

    init {
        getHistoryList()
    }

    fun getHistoryList() {

        _uiState.update { state ->
            state.copy(isLoading = true)
        }

        viewModelScope.launch {
            getAllQuizHistoryUseCase().collectLatest { list ->
                _uiState.update { state ->
                    state.copy(
                        isLoading = false,
                        historyList = list
                    )
                }
            }
        }

    }

    fun deleteById(quizId: Int) {
        viewModelScope.launch {
            deleteQuizUseCase(quizId)
        }
    }

}