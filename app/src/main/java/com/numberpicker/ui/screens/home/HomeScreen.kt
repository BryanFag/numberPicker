package com.numberpicker.ui.screens.home
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.numberpicker.R

@Composable
fun HomeScreen(onNavigateToDraw: () -> Unit) {

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
                text = "NUMBER PICKER".uppercase(),
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
                .padding(start = 25.dp, end = 25.dp)
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
                            Color(0xFF797979))),
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
                    fontSize = 50.sp,
                    fontWeight = FontWeight.ExtraBold,
                )
            )
            Text(
                modifier = Modifier
                    .padding(top = 40.dp),
                text = "QUERO SORTEAR:",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Medium,
                )
            )
            Text(
                modifier = Modifier
                    .padding(top = 5.dp),
                text = "Defina o intervalo e a quantidade de números," +
                        " clique em \"Sortear\" e veja os resultados na" +
                        " tela. É rápido e fácil!",
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
                    text = "NÚMEROS".uppercase(),
                    Modifier.padding(bottom = 10.dp),
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = FontFamily(Font(R.font.sora)))
                )
                    Box(
                        modifier = Modifier
                            .background(Color.Gray,
                                shape = RoundedCornerShape(8.dp))
                            .height(85.dp)
                            .width(85.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "1",
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 40.sp,
                                fontWeight = FontWeight.ExtraBold,
                                fontFamily = FontFamily(Font(R.font.sora))
                            )
                        )
                    }
                }

                Column(
                    modifier = Modifier.padding(end = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(
                        text = "de".uppercase(),
                        Modifier.padding(bottom = 10.dp),
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = FontFamily(Font(R.font.sora)))
                    )
                    Box(
                        modifier = Modifier
                            .background(Color.Gray,
                                shape = RoundedCornerShape(8.dp))
                            .height(85.dp)
                            .width(85.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "1",
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 40.sp,
                                fontWeight = FontWeight.ExtraBold,
                                fontFamily = FontFamily(Font(R.font.sora))
                            )
                        )
                    }
                }
                Column(
                    modifier = Modifier.padding(end = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(
                        text = "até".uppercase(),
                        Modifier.padding(bottom = 10.dp),
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = FontFamily(Font(R.font.sora)))
                    )
                    Box(
                        modifier = Modifier
                            .background(Color.Gray,
                                shape = RoundedCornerShape(8.dp))
                            .height(85.dp)
                            .width(85.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "1",
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 40.sp,
                                fontWeight = FontWeight.ExtraBold,
                                fontFamily = FontFamily(Font(R.font.sora))
                            )
                        )
                    }
                }
            }

            Row(
                modifier = Modifier.padding(top = 20.dp)
            ) {
                var isChecked by remember { mutableStateOf(true) }
                Switch(
                    modifier = Modifier,
                    checked = isChecked,
                    onCheckedChange = { isChecked = it },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.White,
                        checkedTrackColor = Color(0xFF15f4ee),
                        uncheckedThumbColor = Color.White,
                        uncheckedTrackColor = Color.LightGray
                    )
                )
                Text(
                    modifier = Modifier.padding(top = 15.dp, start = 10.dp),
                    text = "Não repetir números",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily(Font(R.font.sora))
                    )
                )
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp)
                    .height(60.dp),
                onClick = onNavigateToDraw,
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF15f4ee),
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "SORTEAR",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.sora))
                    )
                )
                Icon(
                    modifier = Modifier.padding(start = 10.dp),
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
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
                text = "Sim, você pode definir os valores" +
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
    HomeScreen(
        onNavigateToDraw = TODO()
    )
}