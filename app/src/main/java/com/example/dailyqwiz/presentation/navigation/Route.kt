package com.example.dailyqwiz.presentation.navigation

sealed class Route {

    data class MainScreen(val route: String = "main") : Route()

    data class ResultScreen(val route: String = "result") : Route()

    data class HistoryScreen(val route: String = "history") : Route()

}