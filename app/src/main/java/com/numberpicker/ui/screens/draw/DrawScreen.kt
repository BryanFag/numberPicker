package com.numberpicker.ui.screens.draw

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.numberpicker.R
import com.numberpicker.ui.screens.home.HomeViewModel
import kotlin.math.log

@Composable
fun DrawScreen(
    onBack: () -> Unit,
    number: List<Int>?,
    ) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .padding(top = 50.dp),

        verticalArrangement = Arrangement.Top,
    ) {

        /**
         * Title
         */
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.dice),
                contentDescription = "",
                Modifier.padding(end = 12.dp)
            )
            Text(
                text = "Sorteador Pro".uppercase(),
                style = TextStyle(
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily(Font(R.font.sora))
                )
            )
        }


        /**
         * Subtitle
         */
        Column(
            modifier = Modifier
                .padding(start = 25.dp, end = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        )
        {
            Text(
                modifier = Modifier
                    .padding(top = 50.dp),
                text = "ONLINE - GRATUITO",
                style = TextStyle(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFFC7C9CC),
                            Color(0xFF797979)
                        )),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.sora))
                )
            )
            Text(
                modifier = Modifier
                    .padding(top = 10.dp),
                text = "SORTEADOR DE NÚMEROS",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold,
                )
            )
            Text(
                modifier = Modifier
                    .padding(top = 40.dp),

                text = "resultado do sorteio".uppercase(),
                style = TextStyle(
                    color = Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Medium,
                )
            )
            Text(
                modifier = Modifier
                    .padding(top = 5.dp),
                text = "1º resultado".uppercase(),
                style = TextStyle(
                    color = Color.LightGray,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                )
            )

            /**
             * Input
             */
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp),
                horizontalArrangement = Arrangement.Center,

                ) {
                Column(
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp)
                ) {
                    Text(
                        text = number?.joinToString(", ") ?: "-",
                        style = TextStyle(
                            color = Color.Cyan,
                            fontSize = 40.sp,
                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = FontFamily(Font(R.font.sora))
                        )
                    )
                }
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp)
                    .height(60.dp),
                onClick = onBack,
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF15f4ee),
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "SORTEAR NOVAMENTE",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.sora))
                    )
                )
                Icon(
                    modifier = Modifier.padding(start = 10.dp),
                    painter = painterResource(id = R.drawable.outline_frame_reload_24),
                    contentDescription = "Sortear",
                    tint = Color.White,
                )
            }
            Text(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth(),
                text = "Como funciona o sorteio?",
                style = TextStyle(
                    color = Color(0xFF3EBDB8),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily(Font(R.font.sora))
                )
            )
            Text(
                modifier = Modifier
                    .padding(top = 5.dp)
                    .fillMaxWidth(),
                text = "O sorteador utiliza um algoritmo de geração" +
                        " aleatória para criar números dentro do intervalo" +
                        " especificado pelo usuário.",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily(Font(R.font.sora))
                )
            )
            Text(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth(),
                text = "Posso escolher o intervalo dos números?",
                style = TextStyle(
                    color = Color(0xFF3EBDB8),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily(Font(R.font.sora))
                )
            )
            Text(
                modifier = Modifier
                    .padding(top = 5.dp)
                    .fillMaxWidth(),
                text = "Sim, você pode definir os valores " +
                        "mínimo e máximo para o intervalo dos números sorteados.",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily(Font(R.font.sora))
                )
            )
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun PreviewScreen() {
    DrawScreen(
        onBack = {},
        number = listOf(10, 20, 30, 40, 50)
    )
}