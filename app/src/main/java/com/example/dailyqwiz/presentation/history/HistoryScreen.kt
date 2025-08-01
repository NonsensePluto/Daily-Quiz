package com.example.dailyqwiz.presentation.history

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.dailyqwiz.ui.theme.BlueBackground

@Composable
fun HistoryScreen(

) {
    Scaffold {
            paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BlueBackground)
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        }
    }
}