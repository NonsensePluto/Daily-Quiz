package com.example.dailyqwiz.presentation.resultscreen.utils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ResultConfirmButton(
    modifier: Modifier = Modifier,
    bodyColor: Color,
    textColor: Color,
    onButtonClick: () -> Unit,
    text: String
) {

    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 50.dp)
            .height(50.dp),
        onClick = onButtonClick,
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = bodyColor, contentColor = textColor)
    ) {
        Text(
            text = text,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}