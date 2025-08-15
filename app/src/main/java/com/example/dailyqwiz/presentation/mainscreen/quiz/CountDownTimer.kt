package com.example.dailyqwiz.presentation.mainscreen.quiz

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.dailyqwiz.presentation.ui.theme.LargeText
import kotlinx.coroutines.delay

@Composable
fun CountDownTimer(
    modifier: Modifier = Modifier,
    time: Long,
    color: Color,
    onFinish: () -> Unit,
) {
    var currentTimeMillis by remember(time) { mutableLongStateOf(time) }

    val latestOnFinish by rememberUpdatedState(newValue = onFinish)

    LaunchedEffect(time) {
        currentTimeMillis = time
        if (currentTimeMillis <= 0L) {
            latestOnFinish()
            return@LaunchedEffect
        }
        while (currentTimeMillis > 0L) {
            delay(1000L)
            currentTimeMillis = (currentTimeMillis - 1000L).coerceAtLeast(0L)
        }
        latestOnFinish()
    }

    val totalSeconds = (currentTimeMillis / 1000L).coerceAtLeast(0L)
    val minutes = totalSeconds / 60
    val seconds = totalSeconds % 60
    val timeText = String.format("%02d:%02d", minutes, seconds)

    Text(
        modifier = modifier,
        text = timeText,
        color = color,
        fontSize = LargeText,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold
    )
}
