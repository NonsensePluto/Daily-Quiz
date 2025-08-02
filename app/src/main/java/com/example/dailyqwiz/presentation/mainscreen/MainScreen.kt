package com.example.dailyqwiz.presentation.mainscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dailyqwiz.ui.theme.BlueBackground
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.animateContentSize
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.dailyqwiz.presentation.mainscreen.utils.TitleText
import com.example.dailyqwiz.presentation.mainscreen.quiz.QuizCard
import com.example.dailyqwiz.presentation.mainscreen.utils.ErrorCard
import com.example.dailyqwiz.presentation.mainscreen.utils.HistoryButton
import com.example.dailyqwiz.presentation.mainscreen.utils.WelcomeCard
import com.example.dailyqwiz.presentation.mainscreen.viewmodel.MainScreenViewModel


@Composable
fun MainScreen (
    mainScreenViewModel: MainScreenViewModel = hiltViewModel()
) {

    val state by mainScreenViewModel.uiState.collectAsStateWithLifecycle()
    var selectedAnswer by remember { mutableStateOf<String?>(null) }
    var isQuizStarted = state.questions.isNotEmpty()

    Scaffold {
        paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BlueBackground)
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedVisibility(visible = !isQuizStarted) {
                HistoryButton(
                    onClick = { },
                    modifier = Modifier
                        .padding(top = 100.dp)
                )
            }

            TitleText(
                modifier = Modifier
                    .padding(top = if (isQuizStarted) 50.dp else 150.dp)
                    .animateContentSize(animationSpec = tween(500)),
                text = "DAILY QUIZ"
            )

            if (isQuizStarted) {
                val currentQuestion = state.questions.first()
                QuizCard(
                    totalQuestions = state.questions.size + state.userAnswers.size,
                    questionNumber = state.userAnswers.size + 1,
                    question = currentQuestion.question,
                    shuffledAnswers = state.currentShuffledAnswers,
                    selectedAnswer = selectedAnswer,
                    onSelectAnswer = { selectedAnswer = it },
                    onNextQuestion = {
                        if (selectedAnswer != null) {
                            mainScreenViewModel.onNextQuestion(selectedAnswer!!)
                            selectedAnswer = null
                        }
                    },
                    onEndQuiz = { }
                )
            } else {

                when {
                    state.error != null -> {
                        ErrorCard(state.error!!)
                    }

                    state.isLoading -> {
                        CircularProgressIndicator()
                    }

                    else -> {
                        WelcomeCard(
                            modifier = Modifier
                                .padding(top = 24.dp),
                            onStartQuizClick = {
                                mainScreenViewModel.getQuizQuestions()
                                isQuizStarted = true
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}
