package com.example.dailyqwiz.presentation.mainscreen.quiz

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.dailyqwiz.domain.utils.TextDecoder
import com.example.dailyqwiz.presentation.generalutils.AnswerOption
import com.example.dailyqwiz.presentation.generalutils.CardButton
import com.example.dailyqwiz.presentation.ui.theme.BigRadius
import com.example.dailyqwiz.presentation.ui.theme.BlueBackground
import com.example.dailyqwiz.presentation.ui.theme.DeepPurple
import com.example.dailyqwiz.presentation.ui.theme.DefaultPadding
import com.example.dailyqwiz.presentation.ui.theme.DirtyWhite
import com.example.dailyqwiz.presentation.ui.theme.FullBlack
import com.example.dailyqwiz.presentation.ui.theme.FullWhite
import com.example.dailyqwiz.presentation.ui.theme.LightGreen
import com.example.dailyqwiz.presentation.ui.theme.LightPurple
import com.example.dailyqwiz.presentation.ui.theme.Red

@Composable
fun QuizCard(
    modifier: Modifier = Modifier,
    questionNumber: Int,
    totalQuestions: Int,
    question: String,
    shuffledAnswers: List<String>,
    selectedAnswer: String?,
    isAnswerLocked: Boolean,
    isAnswerCorrect: Boolean?,
    correctAnswer: String,
    onSelectAnswer: (String) -> Unit,
    onNextQuestion: () -> Unit,
    onEndQuiz: () -> Unit,
    time: Long = 300000L,
    onTimeLeft: () -> Unit,
) {
    val isLastQuestion = questionNumber == totalQuestions

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(DefaultPadding),
        shape = RoundedCornerShape(BigRadius),
        colors = CardDefaults.cardColors(containerColor = FullWhite),
    ) {
        Column(
            modifier = Modifier.padding(DefaultPadding),
        ) {
            CountDownTimer(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                color = FullBlack,
                onFinish = onTimeLeft,
                time = time
            )

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
                text = TextDecoder.decode(question),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            shuffledAnswers.forEach { answer ->
                AnswerOption(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp),
                    answer = answer,
                    isSelected = selectedAnswer == answer,
                    enabled = !isAnswerLocked,
                    color = getAnswerColor(
                        answer = answer,
                        selectedAnswer = selectedAnswer,
                        isAnswerLocked = isAnswerLocked,
                        isAnswerCorrect = isAnswerCorrect,
                        correctAnswer = correctAnswer
                    ),
                    onClick = { if (!isAnswerLocked) onSelectAnswer(answer) }
                )
            }

            CardButton(
                onClick = if (isLastQuestion) onEndQuiz else onNextQuestion,
                color = BlueBackground,
                text = if (isLastQuestion) "завершить" else "далее",
                textColor = DirtyWhite,
                enabled = selectedAnswer != null && !isAnswerLocked
            )

        }
    }
}

private fun getAnswerColor(
    answer: String,
    selectedAnswer: String?,
    isAnswerLocked: Boolean,
    isAnswerCorrect: Boolean?,
    correctAnswer: String
): Color {
    return when {
        !isAnswerLocked && selectedAnswer == answer -> DeepPurple
        selectedAnswer == answer && isAnswerCorrect == true -> LightGreen
        selectedAnswer == answer && isAnswerCorrect == false -> Red
        isAnswerLocked && answer == correctAnswer -> LightGreen
        else -> DirtyWhite
    }
}


//@Preview(showBackground = true)
////@Composable
////fun QuizCardPreview() {
////    QuizCard(
////        totalQuestions = 10,
////        questionNumber = 1,
////        question = "What is the capital of France?",
////        shuffledAnswers = listOf("Paris", "London", "Berlin", "Madrid"),
////        selectedAnswer = null,
////        onSelectAnswer = { },
////        onNextQuestion = { },
////        isAnswerLocked = false,
////        isAnswerCorrect = false,
////        correctAnswer = "",
////        onEndQuiz = {  },
////        onTimeLeft = { }
////    )
////}

