package com.example.dailyqwiz.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.dailyqwiz.presentation.ui.theme.Grey
import com.example.dailyqwiz.presentation.ui.theme.StarYellow

@Composable
fun StarsRow(
    modifier: Modifier = Modifier,
    result: Int,
    maxResult: Int,
    starSize: Dp = 50.dp
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        var yellowStarFlag = true
        for (i in 1..maxResult) {
            if (i > result && yellowStarFlag) {
                yellowStarFlag = false
            }

            Icon(
                modifier = Modifier
                    .size(starSize),
                imageVector = Icons.Filled.Star,
                tint = if (yellowStarFlag) StarYellow else Grey,
                contentDescription = "Счет пользователя",
            )
        }
    }
}