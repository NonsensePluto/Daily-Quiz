package com.example.dailyqwiz.presentation.resultscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.dailyqwiz.presentation.generalutils.CardButton
import com.example.dailyqwiz.presentation.resultscreen.utils.ResultAnswerCard
import com.example.dailyqwiz.presentation.viewmodel.MainViewModel
import com.example.dailyqwiz.presentation.resultscreen.utils.ResultCard
import com.example.dailyqwiz.presentation.ui.theme.BlueBackground
import com.example.dailyqwiz.presentation.ui.theme.DeepPurple
import com.example.dailyqwiz.presentation.ui.theme.FullWhite

@Composable
fun ResultScreen(
    mainViewModel: MainViewModel = hiltViewModel(),
    onNavigateToHomeScreen: () -> Unit,
) {

    val state by mainViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold {
        paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BlueBackground)
                .padding(paddingValues)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                modifier = Modifier
                    .padding(50.dp),
                color = FullWhite,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                text = "Результаты",
            )

            ResultCard(
                modifier = Modifier
                    .padding(bottom = 16.dp),
                result = state.points,
                maxResult = state.userAnswers.size,
                onNavigateToHomeScreen = onNavigateToHomeScreen
            )

            var questionNumber = 1
            state.userAnswers.forEach { answer ->
                ResultAnswerCard(
                    questionNumber = questionNumber,
                    totalQuestions = state.userAnswers.size,
                    userAnswer = answer,
                    correctAnswer = answer.correctAnswer
                )
                questionNumber++
            }

            CardButton(
                modifier = Modifier
                    .padding(start = 32.dp, end = 32.dp, bottom = 32.dp),
                onClick = onNavigateToHomeScreen,
                color = FullWhite,
                textColor = DeepPurple,
                text = "Начать заново",
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResultScreenPreview() {
    ResultScreen(onNavigateToHomeScreen = { })
}