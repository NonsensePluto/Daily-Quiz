package com.example.dailyqwiz.presentation.mainscreen.utils

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dailyqwiz.presentation.generalutils.TitleText
import com.example.dailyqwiz.presentation.ui.theme.FullWhite

@Composable
fun QuizTopBar(
    modifier: Modifier = Modifier,
    isQuizStarted: Boolean,
    onBackPressed: () -> Unit
) {
    val animatedFontSize by animateFloatAsState(
        targetValue = if (isQuizStarted) 48f else 64f,
        animationSpec = tween(durationMillis = 500)
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp) // высота строки top bar
    ) {
        if (isQuizStarted) {
            IconButton(
                onClick = onBackPressed,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 0.dp) // прижимает максимально к левому краю
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Назад",
                    tint = FullWhite
                )
            }
        }

        TitleText(
            text = "DAILY QUIZ",
            modifier = Modifier
                .align(Alignment.Center),
            fontSize = animatedFontSize.sp // Animated font size
        )
    }
}