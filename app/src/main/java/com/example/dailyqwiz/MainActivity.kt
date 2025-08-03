package com.example.dailyqwiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.dailyqwiz.presentation.navigation.NavigationGraph
import com.example.dailyqwiz.presentation.ui.theme.DailyQwizTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DailyQwizTheme {
                NavigationGraph(
                    navController = rememberNavController(),
                )
            }
        }
    }
}
