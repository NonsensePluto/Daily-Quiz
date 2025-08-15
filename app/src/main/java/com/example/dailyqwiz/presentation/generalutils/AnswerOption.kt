package com.example.dailyqwiz.presentation.generalutils

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
import androidx.compose.material.icons.filled.Cancel
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
import androidx.compose.ui.graphics.Color
import com.example.dailyqwiz.domain.utils.TextDecoder
import com.example.dailyqwiz.presentation.ui.theme.DeepPurple
import com.example.dailyqwiz.presentation.ui.theme.DefaultPadding
import com.example.dailyqwiz.presentation.ui.theme.DirtyWhite
import com.example.dailyqwiz.presentation.ui.theme.FullBlack
import com.example.dailyqwiz.presentation.ui.theme.LightGreen
import com.example.dailyqwiz.presentation.ui.theme.MediumRadius
import com.example.dailyqwiz.presentation.ui.theme.Red

@Composable
fun AnswerOption(
    modifier: Modifier = Modifier,
    answer: String,
    isSelected: Boolean = false,
    enabled: Boolean = true,
    color: Color = Color.Unspecified,
    onClick: () -> Unit = { }
) {
    val bgColor =
        if (color != Color.Unspecified) color else if (isSelected) DeepPurple else DirtyWhite

    val icon = when (bgColor) {
        Red -> Icons.Filled.Cancel
        LightGreen -> Icons.Filled.CheckCircle
        DeepPurple -> Icons.Filled.CheckCircle
        else -> Icons.Outlined.Circle
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(MediumRadius))
            .background(color = DirtyWhite, RoundedCornerShape(MediumRadius))
            .border(
                width = 1.dp,
                color = bgColor,
                shape = RoundedCornerShape(MediumRadius)
            )
            .clickable(
                enabled = enabled,
                onClick = onClick
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(DefaultPadding),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "Answer status",
                tint = if (bgColor == DirtyWhite) FullBlack else bgColor,
            )
            Text(
                modifier = Modifier
                    .padding(start = DefaultPadding),
                text = TextDecoder.decode(answer),
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