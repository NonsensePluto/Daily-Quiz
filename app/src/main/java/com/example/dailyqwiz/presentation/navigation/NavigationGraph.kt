package com.example.dailyqwiz.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.dailyqwiz.presentation.history.HistoryScreen
import com.example.dailyqwiz.presentation.mainscreen.MainScreen
import com.example.dailyqwiz.presentation.resultscreen.ResultScreen
import com.example.dailyqwiz.presentation.viewmodel.MainViewModel

@Composable
fun NavigationGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = "quiz",
        modifier = modifier.fillMaxSize()
    ) {
        navigation(startDestination = Route.MainScreen().route, route = "quiz") {

            composable(route = Route.MainScreen().route) { backStackEntry ->
                val parentEntry = remember(backStackEntry) {
                    navController.getBackStackEntry("quiz")
                }
                val mainScreenViewModel: MainViewModel = hiltViewModel(parentEntry)

                MainScreen(
                    mainViewModel = mainScreenViewModel,
                    onNavigateToResults = {
                        navController.navigate(Route.ResultScreen().route)
                    },
                    onNavigateToHistory = {
                        navController.navigate(Route.HistoryScreen().route)
                    }
                )
            }

            composable(route = Route.ResultScreen().route) { backStackEntry ->
                val parentEntry = remember(backStackEntry) {
                    navController.getBackStackEntry("quiz")
                }
                val resultScreenViewModel: MainViewModel = hiltViewModel(parentEntry)

                ResultScreen(
                    mainViewModel = resultScreenViewModel,
                    onNavigateToHomeScreen = {
                        resultScreenViewModel.resetQuiz()
                        navController.popBackStack(Route.MainScreen().route, inclusive = false)
                    }
                )
            }

            composable(route = Route.HistoryScreen().route) {
                HistoryScreen(
//                    onQuizClick =
                    onNavigateToHomeScreen = { navController.popBackStack(Route.MainScreen().route, inclusive = false) }

                )
            }
        }
    }
}