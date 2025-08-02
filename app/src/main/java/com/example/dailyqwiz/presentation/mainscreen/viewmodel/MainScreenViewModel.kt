package com.example.dailyqwiz.presentation.mainscreen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dailyqwiz.domain.model.QuizQuestionModel
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
            val firstShuffle = getShuffledAnswer(result.firstOrNull())
            _uiState.update { state ->
                state.copy(
                    isLoading = false,
                    questions = result,
                    currentShuffledAnswers = firstShuffle
                )
            }
        }
    }

    fun onNextQuestion(selectedAnswer: String) {
        checkAnswer(selectedAnswer)
        _uiState.update { state ->
            val nextQuestions = state.questions.drop(1)
            val nextShuffle = getShuffledAnswer(nextQuestions.firstOrNull())
            state.copy(
                questions = nextQuestions,
                currentShuffledAnswers = nextShuffle
            )
        }
    }

    private fun getShuffledAnswer(question: QuizQuestionModel?): List<String> {
        return question?.let {
            (it.incorrectAnswers + it.correctAnswer).shuffled()
        } ?: emptyList()
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