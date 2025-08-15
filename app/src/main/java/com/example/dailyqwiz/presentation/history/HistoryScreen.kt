package com.example.dailyqwiz.presentation.history

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.dailyqwiz.presentation.generalutils.ConfirmDialog
import com.example.dailyqwiz.presentation.generalutils.MessageCard
import com.example.dailyqwiz.presentation.history.utils.DeleteMenu
import com.example.dailyqwiz.presentation.history.utils.HistoryQuizItem
import com.example.dailyqwiz.presentation.history.viewmodel.HistoryViewModel
import com.example.dailyqwiz.presentation.ui.theme.BigScreenPadding
import com.example.dailyqwiz.presentation.ui.theme.BlueBackground
import com.example.dailyqwiz.presentation.ui.theme.DefaultPadding
import com.example.dailyqwiz.presentation.ui.theme.FullWhite

@Composable
fun HistoryScreen(
    historyViewModel: HistoryViewModel = hiltViewModel(),
//    onQuizClick: (Int) -> Unit,
    onNavigateToHomeScreen: () -> Unit,

) {

    val state by historyViewModel.uiState.collectAsStateWithLifecycle()
    var menuQuizId by remember { mutableStateOf<Int?>(null) }
    var showDeletionConfirmation by remember { mutableStateOf(false) }
    val color = BlueBackground


    if (showDeletionConfirmation) {
        ConfirmDialog(
            onClose = { showDeletionConfirmation = false },
            titleText = "Попытка удалена",
            subTitleText = "Вы можете пройти викторину снова, когда будете готовы.",
            buttonText = "ЗАКРЫТЬ"
            )
    }

    Scaffold {
            paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color)
                .padding(paddingValues)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .padding(BigScreenPadding),
                color = FullWhite,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                text = "История",
            )

            when {
                state.historyList.isEmpty() -> {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(DefaultPadding),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        MessageCard(
                            modifier = Modifier
                                .padding(top = DefaultPadding),
                            onButtonClick = onNavigateToHomeScreen,
                            messageText = "Вы еще не проходили\n ни одной викторины",
                            buttonText = "начать викторину",
                        )
//                        Spacer(modifier = Modifier.weight(1f))
//                        TitleText(
//                            modifier = Modifier,
//                            text = "DAILY QUIZ"
//                        )
                    }

                }
                else -> {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(DefaultPadding),
                    ) {
                        state.historyList.forEach { historyItem ->
                            HistoryQuizItem(
                                modifier = Modifier.padding(vertical = 8.dp),
                                quiz = historyItem,
                                isSelected = if(menuQuizId == null) true else menuQuizId == historyItem.id,
                                onClick = { },
                                onLongPress = { menuQuizId = historyItem.id }
                            )
                        }
                    }

                    // Затемнение и меню
                    if (menuQuizId != null) {
                        Box(
                            Modifier
                                .fillMaxSize()
                                .background(Color(0x99000000))
                                .clickable { menuQuizId = null }
                        )

                        Box(
                            Modifier
                                .fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            DeleteMenu(
                                onDelete = {
                                    historyViewModel.deleteById(menuQuizId!!)
                                    menuQuizId = null
                                    showDeletionConfirmation = true
                                           },
                                onDismiss = { menuQuizId = null }
                            )
                        }
                    }
                }

            }

        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun HistoryScreenPreview() {
//    HistoryScreen(onQuizClick = {})
//}