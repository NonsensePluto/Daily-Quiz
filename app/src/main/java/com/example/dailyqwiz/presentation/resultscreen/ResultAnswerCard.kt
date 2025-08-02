package com.example.dailyqwiz.presentation.resultscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dailyqwiz.ui.theme.FullBlack
import com.example.dailyqwiz.ui.theme.FullWhite
import com.example.dailyqwiz.ui.theme.Grey
import com.example.dailyqwiz.ui.theme.LightGreen
import com.example.dailyqwiz.ui.theme.Red

@Composable
fun ResultAnswerCard(
    modifier: Modifier = Modifier,
    questionNumber: Int,
    totalQuestions: Int,
    question: String,
    answers: List<String>,
    userAnswer: String,
    correctAnswer: String
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(32.dp),
        colors = CardDefaults.cardColors(containerColor = FullWhite),
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Вопрос $questionNumber из $totalQuestions",
                    color = Grey,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    imageVector = if(userAnswer == correctAnswer) Icons.Filled.CheckCircle else Icons.Filled.Cancel,
                    contentDescription = "Статус ответа",
                    tint = if(userAnswer == correctAnswer) LightGreen else Red,
                )
            }
            Text(
                text = question,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                color = FullBlack,
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 16.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            answers.forEach { answer ->
                ResultAnswerOption(
                    answer = answer,
                    isCorrect = answer == correctAnswer,
                    isWrong = (answer == userAnswer && userAnswer != correctAnswer)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResultAnswerCardPreview() {
    ResultAnswerCard(
        questionNumber = 1,
        totalQuestions = 5,
        question = "Как переводится слово \"apple\"?",
        answers = listOf("Груша", "Яблоко", "Апельсин", "Ананас"),
        userAnswer = "Груша",
        correctAnswer = "Яблоко"
    )
}