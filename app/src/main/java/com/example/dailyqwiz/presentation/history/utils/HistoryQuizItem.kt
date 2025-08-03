package com.example.dailyqwiz.presentation.history.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dailyqwiz.domain.model.QuizHistory
import com.example.dailyqwiz.domain.utils.DateAndTimeFormatter
import com.example.dailyqwiz.presentation.generalutils.StarsRow
import com.example.dailyqwiz.presentation.ui.theme.BigRadius
import com.example.dailyqwiz.presentation.ui.theme.DeepPurple
import com.example.dailyqwiz.presentation.ui.theme.DefaultPadding
import com.example.dailyqwiz.presentation.ui.theme.FullWhite

@Composable
fun HistoryQuizItem(
    quiz: QuizHistory,
    isSelected: Boolean,
    onClick: () -> Unit,
    onLongPress: () -> Unit,
    modifier: Modifier = Modifier
) {
    val score = quiz.points
    val max = quiz.userAnswers.size
    val dateString = DateAndTimeFormatter.formatDate(quiz.date)
    val timeString = DateAndTimeFormatter.formatTime(quiz.time)

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(BigRadius))
            .combinedClickable(
                onClick = onClick,
                onLongClick = onLongPress
            )
            .background(if (isSelected) FullWhite else FullWhite.copy(alpha = 0.7f))
            .padding(DefaultPadding)
            .fillMaxWidth()


    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = quiz.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                    color = DeepPurple,
                )
                StarsRow(
                    result = score,
                    maxResult = max,
                    modifier = Modifier
                        .padding(start = 8.dp),
                    starSize = 24.dp
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = dateString,
                    fontSize = 14.sp,
                    color = DeepPurple,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = timeString,
                    fontSize = 14.sp,
                    color = DeepPurple,
                )
            }
        }
    }
}