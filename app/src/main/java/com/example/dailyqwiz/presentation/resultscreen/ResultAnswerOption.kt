package com.example.dailyqwiz.presentation.resultscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dailyqwiz.ui.theme.DeepPurple
import com.example.dailyqwiz.ui.theme.FullBlack
import com.example.dailyqwiz.ui.theme.DirtyWhite
import com.example.dailyqwiz.ui.theme.FullWhite
import com.example.dailyqwiz.ui.theme.LightGreen
import com.example.dailyqwiz.ui.theme.Red

@Composable
fun ResultAnswerOption(
    answer: String,
    isCorrect: Boolean = false,
    isWrong: Boolean = false,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .background(
                color = if (isCorrect || isWrong) FullWhite else DirtyWhite,
                shape = RoundedCornerShape(16.dp)
            )
            .border(
                width = if (isCorrect || isWrong) 1.dp else (-1).dp,
                color = if(isCorrect) LightGreen else Red,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(16.dp)
    ) {
        Icon(
            imageVector = when {
                isCorrect -> Icons.Filled.CheckCircle
                isWrong -> Icons.Filled.Cancel
                else -> Icons.Outlined.Circle
            },
            contentDescription = null,
            tint = when {
                isCorrect -> LightGreen
                isWrong -> Red
                else -> FullBlack
            }
        )
        Text(
            text = answer,
            color = when {
                isCorrect -> LightGreen
                isWrong -> Red
                else -> FullBlack
            },
            modifier = Modifier.padding(start = 8.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    }
}
