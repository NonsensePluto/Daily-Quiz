package com.example.dailyqwiz.presentation.mainscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dailyqwiz.domain.usecases.GetQuizQuestionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getQuizQuestionsUseCase: GetQuizQuestionsUseCase
) : ViewModel(){
    private val _uiState = MutableStateFlow(MainScreenState())
    val uiState: StateFlow<MainScreenState> = _uiState.asStateFlow()

    fun getQuizQuestions(){
        _uiState.update { state ->
            state.copy(isLoading = true)
        }

        viewModelScope.launch {
            val result = getQuizQuestionsUseCase()
            _uiState.update { state ->
                state.copy(
                    isLoading = false,
                    questions = result
                )
            }
        }
    }

    fun onNextQuestion(selectedAnswer: String) {//поменять все
        _uiState.update { state ->
            val current = state.questions.firstOrNull()
            val isCorrect = current?.correctAnswer == selectedAnswer
            val updatedPoints = if (isCorrect) state.points + 1 else state.points
            val updatedUserAnswers = if (current != null)
                state.userAnswers + UserAnswer(current, selectedAnswer)
            else state.userAnswers
            state.copy(
                questions = state.questions.drop(1),
                userAnswers = updatedUserAnswers,
                points = updatedPoints
            )
        }
    }
    
    private fun checkAnswer(answer: String) {
        _uiState.update { state ->
            state.copy(
                points = if (state.questions.first().correctAnswer == answer) state.points + 1 else state.points,
                userAnswers = state.userAnswers + UserAnswer(state.questions.first(), answer)
            )
        }
    }
}