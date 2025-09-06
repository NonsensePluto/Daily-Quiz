package com.example.dailyqwiz.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dailyqwiz.domain.model.QuizQuestionModel
import com.example.dailyqwiz.domain.model.UserAnswer
import com.example.dailyqwiz.domain.usecases.database.SaveQuizUseCase
import com.example.dailyqwiz.domain.usecases.remote.GetQuizQuestionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getQuizQuestionsUseCase: GetQuizQuestionsUseCase,
    private val saveQuizUseCase: SaveQuizUseCase
) : ViewModel(){
    private val _uiState = MutableStateFlow(MainState())
    val uiState: StateFlow<MainState> = _uiState.asStateFlow()

    fun getQuizQuestions(){
        try {
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
        } catch (e: Exception) {
            _uiState.update { state ->
                state.copy(
                    isLoading = false,
                    error = "Ошибка при загрузке данных: ${e.message}"
                )
            }
        }
    }

    fun onNextQuestion(selectedAnswer: String) {
        _uiState.update { state ->
            val nextQuestions = state.questions.drop(1)
            val nextShuffle = getShuffledAnswer(nextQuestions.firstOrNull())
            state.copy(
                questions = nextQuestions,
                currentShuffledAnswers = nextShuffle
            )
        }
    }

    fun saveQuizResult() {
        viewModelScope.launch(Dispatchers.IO) {
            val state = _uiState.value
            saveQuizUseCase(state.userAnswers, state.points)
        }
    }

    private fun getShuffledAnswer(question: QuizQuestionModel?): List<String> {
        return question?.let {
            (it.incorrectAnswers + it.correctAnswer).shuffled()
        } ?: emptyList()
    }
    
    fun checkAnswer(answer: String): Boolean {
        var result = false
        _uiState.update { state ->
            result = state.questions.first().correctAnswer == answer
            state.copy(
                points = if (result) state.points + 1 else state.points,
                userAnswers = state.userAnswers + UserAnswer(
                    questionText = state.questions.first().question,
                    allOptions = state.currentShuffledAnswers,
                    selected = answer,
                    correctAnswer = state.questions.first().correctAnswer
                )
            )
        }
        return result
    }

    fun resetQuiz() {
        _uiState.value = MainState()
    }
}