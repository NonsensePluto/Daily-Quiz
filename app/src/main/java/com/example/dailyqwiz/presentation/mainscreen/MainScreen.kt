package com.example.dailyqwiz.presentation.mainscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dailyqwiz.ui.theme.BlueBackground
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.dailyqwiz.ui.theme.FullWhite
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.dailyqwiz.R
import com.example.dailyqwiz.presentation.general.TitleText
import com.example.dailyqwiz.ui.theme.DirtyWhite
import com.example.dailyqwiz.ui.theme.FullBlack

@Composable
fun MainScreen (

) {
    Scaffold {
        paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BlueBackground)
                .padding(paddingValues),
            horizontalAlignment = CenterHorizontally,
        ) {
            HistoryButton(
                onClick = { },
                modifier = Modifier
                    .padding(top = 100.dp)
            )

            TitleText(
                modifier = Modifier
                    .padding(top = 150.dp),
                text = "DAILY QUIZ"
            )

            WelcomeCard(modifier = Modifier
                .padding(top = 24.dp)
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}
