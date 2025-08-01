package com.example.dailyqwiz.presentation.mainscreen.quiz

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dailyqwiz.ui.theme.DeepPurple
import com.example.dailyqwiz.ui.theme.DirtyWhite
import com.example.dailyqwiz.ui.theme.FullBlack

@Composable
fun AnswerOption(
    answer: String,
    isSelected: Boolean = false,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(50.dp)
            .background(DirtyWhite, RoundedCornerShape(16.dp))
            .border(width = if (isSelected) 1.dp else 0.dp, color = DeepPurple)
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = onClick)
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = if (isSelected) Icons.Filled.CheckCircle else Icons.Outlined.Circle,
                contentDescription = "Answer status",
                tint = if (isSelected) DeepPurple else FullBlack,
            )
            Text(
                text = answer,
                color = if (isSelected) DeepPurple else FullBlack,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnswerOptionPreview() {
    AnswerOption(answer = "Answer", isSelected = true, onClick = {})
}