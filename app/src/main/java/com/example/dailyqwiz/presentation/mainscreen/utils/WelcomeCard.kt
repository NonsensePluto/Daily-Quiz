package com.example.dailyqwiz.presentation.mainscreen.utils

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
import com.example.dailyqwiz.ui.theme.DirtyWhite
import com.example.dailyqwiz.ui.theme.FullBlack
import com.example.dailyqwiz.ui.theme.FullWhite

@Composable
fun WelcomeCard(
    modifier: Modifier = Modifier,
    onStartQuizClick: () -> Unit
) {
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
                text = "Добро пожаловать\nв DailyQuiz!",
                fontSize = 32.sp,
                color = FullBlack,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                lineHeight = 40.sp
            )
            Button(
                onClick = onStartQuizClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp, start = 24.dp, end = 24.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = BlueBackground),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    text = "начать викторину",
                    fontSize = 24.sp,
                    color = DirtyWhite,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeCardPreview() {
    WelcomeCard(
        onStartQuizClick = { /* Handle button click */ }
    )
}