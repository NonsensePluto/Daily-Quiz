package com.example.dailyqwiz.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dailyqwiz.presentation.ui.theme.BlueBackground
import com.example.dailyqwiz.presentation.ui.theme.DirtyWhite
import com.example.dailyqwiz.presentation.ui.theme.FullBlack
import com.example.dailyqwiz.presentation.ui.theme.FullWhite

@Composable
fun MessageCard(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit,
    shape: RoundedCornerShape = RoundedCornerShape(32.dp),
    cardColor: Color = FullWhite,
    messageText: String,
    messageTextColor: Color = FullBlack,
    fontSize: TextUnit = 24.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    buttonText: String,
    buttonTextColor: Color = DirtyWhite,
    buttonColor: Color = BlueBackground
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = shape,
        colors = CardDefaults.cardColors(containerColor = cardColor),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = messageText,
                fontSize = fontSize,
                color = messageTextColor,
                fontWeight = fontWeight,
                textAlign = TextAlign.Center,
                lineHeight = 40.sp
            )

            CardButton(
                onClick = onButtonClick,
                color = buttonColor,
                textColor = buttonTextColor,
                text = buttonText,
            )
        }
    }
}