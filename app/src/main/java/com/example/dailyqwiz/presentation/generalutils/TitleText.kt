package com.example.dailyqwiz.presentation.generalutils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.dailyqwiz.R
import com.example.dailyqwiz.presentation.ui.theme.FullWhite

val GothamRounded = FontFamily(
    Font(R.font.gothamrndssm_bold, FontWeight.Bold)
)

@Composable
fun TitleText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = 64.sp,
) {
    Text(
        modifier = modifier,
        text = text,
        color = FullWhite,
        fontWeight = FontWeight.Bold,
        fontSize = fontSize,
        fontFamily = GothamRounded,
        letterSpacing = (-10).sp
    )
}

@Preview(showBackground = true)
@Composable
fun TitleTextPreview() {
    TitleText(text = "DAILYQUIZ", modifier = Modifier.fillMaxWidth())
}