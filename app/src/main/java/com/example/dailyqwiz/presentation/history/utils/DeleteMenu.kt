package com.example.dailyqwiz.presentation.history.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.dailyqwiz.presentation.ui.theme.FullBlack
import com.example.dailyqwiz.presentation.ui.theme.FullWhite
import com.example.dailyqwiz.presentation.ui.theme.MediumRadius
import com.example.dailyqwiz.presentation.ui.theme.MediumText

@Composable
fun DeleteMenu(
    onDelete: () -> Unit,
    onDismiss: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(MediumRadius))
            .background(FullWhite)
            .padding(vertical = 8.dp, horizontal = 20.dp)
            .clickable(
                onClick = onDelete
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = Icons.Filled.Delete,
                contentDescription = "Удалить",
                tint = FullBlack,
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(
                text = "Удалить",
                color = FullBlack,
                fontSize = MediumText
            )
        }
    }
}