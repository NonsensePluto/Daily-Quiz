package com.example.dailyqwiz.presentation.resultscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.example.dailyqwiz.presentation.resultscreen.utils.StarsRow
import com.example.dailyqwiz.ui.theme.BlueBackground
import com.example.dailyqwiz.ui.theme.FullBlack
import com.example.dailyqwiz.ui.theme.FullWhite
import com.example.dailyqwiz.ui.theme.StarYellow

@Composable
fun ResultCard(
    modifier: Modifier = Modifier,
    result: Int,
    maxResult: Int,
) {
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
                text = "Хорошая работа!",
                color = FullBlack,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                text = "Ваш результат:$result из $maxResult",
                color = FullBlack,
                textAlign = TextAlign.Center,
                fontSize = 18.sp
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp)
                    .height(50.dp),
                onClick = {  },
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = BlueBackground, contentColor = FullWhite)
            ) {
                Text(
                    text = "Начать заново",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }



        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResultCardPreview() {
    ResultCard(result = 0, maxResult = 5)
}