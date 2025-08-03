package com.example.dailyqwiz.presentation.mainscreen

import android.widget.Toast
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
import com.example.dailyqwiz.presentation.ui.theme.BlueBackground
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.dailyqwiz.presentation.generalutils.MessageCard
import com.example.dailyqwiz.presentation.mainscreen.quiz.QuizCard
import com.example.dailyqwiz.presentation.mainscreen.utils.ErrorCard
import com.example.dailyqwiz.presentation.mainscreen.utils.HistoryButton
import com.example.dailyqwiz.presentation.mainscreen.utils.QuizTopBar
import com.example.dailyqwiz.presentation.ui.theme.FullWhite
import com.example.dailyqwiz.presentation.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun MainScreen (
    mainViewModel: MainViewModel = hiltViewModel(),
    onNavigateToResults: () -> Unit,
    onNavigateToHistory: () -> Unit
) {

    val state by mainViewModel.uiState.collectAsStateWithLifecycle()
    var selectedAnswer by remember { mutableStateOf<String?>(null) }
    var isAnswerLocked by remember { mutableStateOf(false) }
    var isAnswerCorrect by remember { mutableStateOf<Boolean?>(null) }
    var isQuizStarted = state.questions.isNotEmpty()
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    val onAnswerProcessed: () -> Unit = {
        if (selectedAnswer != null && !isAnswerLocked) {
            val correct = mainViewModel.checkAnswer(selectedAnswer!!)
            isAnswerCorrect = correct
            isAnswerLocked = true
            coroutineScope.launch {
                delay(2000)
                mainViewModel.onNextQuestion(selectedAnswer!!)
                isAnswerLocked = false
                isAnswerCorrect = null
                selectedAnswer = null
            }
        }
    }

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
                    onClick = onNavigateToHistory,
                    modifier = Modifier
                        .padding(top = 100.dp)
                )
            }

            QuizTopBar(
                modifier = Modifier
                    .padding(top = if(isQuizStarted) 50.dp else 100.dp),
                isQuizStarted = isQuizStarted,
                onBackPressed = {
                    mainViewModel.resetQuiz()
                    isQuizStarted = false
                }
            )

            if (isQuizStarted) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val currentQuestion = state.questions.first()
                    QuizCard(
                        totalQuestions = if(isAnswerLocked) state.questions.size + state.userAnswers.size - 1
                            else state.questions.size + state.userAnswers.size,
                        questionNumber = state.userAnswers.size + 1,
                        question = currentQuestion.question,
                        shuffledAnswers = state.currentShuffledAnswers,
                        selectedAnswer = selectedAnswer,
                        isAnswerLocked = isAnswerLocked,
                        isAnswerCorrect = isAnswerCorrect,
                        correctAnswer = currentQuestion.correctAnswer,
                        onSelectAnswer = { selectedAnswer = it },
                        onNextQuestion = onAnswerProcessed,
                        onEndQuiz = {
                            onAnswerProcessed()
                            onNavigateToResults()
                            mainViewModel.saveQuizResult()
                        },
                    )
                    Text(
                        text = "Вернуться к предыдущим вопросам нельзя",
                        fontSize = 12.sp,
                        color = FullWhite
                    )
                }

            } else {

                when {
                    state.error != null -> {
                        state.error?.let { errorText ->
                            LaunchedEffect(errorText) {
                                Toast.makeText(context, errorText, Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                    state.isLoading -> {
                        Box(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    }

                    else -> {
                        MessageCard(
                            modifier = Modifier
                                .padding(top = 24.dp),
                            onButtonClick = {
                                mainViewModel.getQuizQuestions()
                                isQuizStarted = true
                            },
                            messageText = "Добро пожаловать\nв DailyQuiz!",
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            buttonText = "начать викторину",
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
    MainScreen(
        onNavigateToResults = {},
        onNavigateToHistory = {}
    )
}
