package com.example.dailyqwiz.presentation.mainscreen.quiz

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dailyqwiz.ui.theme.BlueBackground
import com.example.dailyqwiz.ui.theme.FullBlack
import com.example.dailyqwiz.ui.theme.FullWhite
import com.example.dailyqwiz.ui.theme.LightPurple

@Composable
fun QuizCard(
    modifier: Modifier = Modifier,
    questionNumber: Int,
    totalQuestions: Int,
    question: String,
    shuffledAnswers: List<String>,
    selectedAnswer: String? = null,
    onSelectAnswer: (String) -> Unit,
    onNextQuestion: () -> Unit = {},
    onEndQuiz: () -> Unit = {}
) {
    val isLastQuestion = questionNumber == totalQuestions

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(32.dp),
        colors = CardDefaults.cardColors(containerColor = FullWhite),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Вопрос $questionNumber из $totalQuestions",
                color = LightPurple,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 20.dp),
                color = FullBlack,
                text = question,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            shuffledAnswers.forEach { answer ->
                AnswerOption(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    answer = answer,
                    isSelected = selectedAnswer == answer,
                    onClick = { onSelectAnswer(answer) }
                )
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp)
                    .height(50.dp),
                onClick = if (isLastQuestion) onEndQuiz else onNextQuestion,
                enabled = selectedAnswer != null,
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = BlueBackground, contentColor = FullWhite)
            ) {
                Text(
                    text = if (isLastQuestion) "завершить" else "далее",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

        }

    }
}


@Preview(showBackground = true)
@Composable
fun QuizCardPreview() {
    QuizCard(
        totalQuestions = 10,
        questionNumber = 1,
        question = "What is the capital of France?",
        shuffledAnswers = listOf("Paris", "London", "Berlin", "Madrid"),
        selectedAnswer = null,
        onSelectAnswer = { },
        onNextQuestion = { }
    )
}