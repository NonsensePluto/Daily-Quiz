package com.example.dailyqwiz.presentation.mainscreen.utils

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ErrorCard(
    text: String
) {
    Text(
        text = text,
        color = MaterialTheme.colorScheme.error,
    )
}