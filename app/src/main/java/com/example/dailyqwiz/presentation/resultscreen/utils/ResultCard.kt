package com.example.dailyqwiz.presentation.resultscreen.utils

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dailyqwiz.presentation.generalutils.CardButton
import com.example.dailyqwiz.presentation.generalutils.StarsRow
import com.example.dailyqwiz.presentation.ui.theme.BlueBackground
import com.example.dailyqwiz.presentation.ui.theme.FullBlack
import com.example.dailyqwiz.presentation.ui.theme.FullWhite
import com.example.dailyqwiz.presentation.ui.theme.StarYellow
import com.example.dailyqwiz.domain.utils.ResultPhrasesGenerator

@Composable
fun ResultCard(
    modifier: Modifier = Modifier,
    result: Int,
    maxResult: Int,
    onNavigateToHomeScreen: () -> Unit
) {
    val (mainPhrase, subPhrase) = ResultPhrasesGenerator.getResultPhrases(result, maxResult)


    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(32.dp),
        colors = CardDefaults.cardColors(containerColor = FullWhite),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            StarsRow(
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally),
                result = result,
                maxResult = maxResult
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                text = "$result из $maxResult",
                color = StarYellow,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp),
                text = mainPhrase,
                color = FullBlack,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                text = subPhrase,
                color = FullBlack,
                textAlign = TextAlign.Center,
                fontSize = 18.sp
            )

            CardButton(
                onClick = onNavigateToHomeScreen,
                color = BlueBackground,
                textColor = FullWhite,
                text = "Начать заново",
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResultCardPreview() {
    ResultCard(result = 0, maxResult = 5, onNavigateToHomeScreen = {})
}