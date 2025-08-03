package com.example.dailyqwiz.presentation.mainscreen.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dailyqwiz.presentation.ui.theme.BlueBackground
import com.example.dailyqwiz.presentation.ui.theme.FullWhite

@Composable
fun HistoryButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    IconButton(
        modifier = modifier
            .clip(shape = RoundedCornerShape(32.dp))
            .background(FullWhite)
            .width(150.dp),
        onClick = onClick,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .wrapContentSize(Alignment.CenterStart),
                text = "История",
                color = BlueBackground,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Icon(
                modifier = Modifier
                    .padding(8.dp)
                    .wrapContentSize(Alignment.CenterEnd),
                imageVector = Icons.Filled.History,
                tint = BlueBackground,
                contentDescription = "Кнопка истории",
            )
        }
    }
}