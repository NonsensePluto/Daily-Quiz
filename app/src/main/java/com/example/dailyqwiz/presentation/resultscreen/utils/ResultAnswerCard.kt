package com.example.dailyqwiz.presentation.resultscreen.utils

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dailyqwiz.domain.model.UserAnswer
import com.example.dailyqwiz.presentation.ui.theme.BigRadius
import com.example.dailyqwiz.presentation.ui.theme.DefaultPadding
import com.example.dailyqwiz.presentation.ui.theme.FullBlack
import com.example.dailyqwiz.presentation.ui.theme.FullWhite
import com.example.dailyqwiz.presentation.ui.theme.Grey
import com.example.dailyqwiz.presentation.ui.theme.LightGreen
import com.example.dailyqwiz.presentation.ui.theme.MediumText
import com.example.dailyqwiz.presentation.ui.theme.Red

@Composable
fun ResultAnswerCard(
    modifier: Modifier = Modifier,
    questionNumber: Int,
    totalQuestions: Int,
    userAnswer: UserAnswer,
    correctAnswer: String
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(DefaultPadding),
        shape = RoundedCornerShape(BigRadius),
        colors = CardDefaults.cardColors(containerColor = FullWhite),
    ) {
        Column(
            modifier = Modifier.padding(DefaultPadding)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Вопрос $questionNumber из $totalQuestions",
                    color = Grey,
                    fontWeight = FontWeight.Bold,
                    fontSize = MediumText,
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    imageVector = if(userAnswer.selected == correctAnswer) Icons.Filled.CheckCircle else Icons.Filled.Cancel,
                    contentDescription = "Статус ответа",
                    tint = if(userAnswer.selected == correctAnswer) LightGreen else Red,
                )
            }
            Text(
                text = userAnswer.questionText,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                color = FullBlack,
                modifier = Modifier
                    .padding(top = 10.dp, bottom = DefaultPadding)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            userAnswer.allOptions.forEach { answer ->
                ResultAnswerOption(
                    answer = answer,
                    isCorrect = answer == correctAnswer,
                    isWrong = (answer == userAnswer.selected && userAnswer.selected != correctAnswer)
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
        userAnswer = UserAnswer(
            questionText = "Какой фрукт является символом яблока?",
            selected = "Банан",
            allOptions = listOf("Банан", "Апельсин", "Яблоко", "Груша"),
            correctAnswer = "Яблоко"
        ),
        correctAnswer = "Яблоко"
    )
}