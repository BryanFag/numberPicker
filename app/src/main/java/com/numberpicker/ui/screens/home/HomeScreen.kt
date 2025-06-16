package com.numberpicker.ui.screens.home

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
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
import androidx.compose.ui.platform.LocalContext
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

@Composable
fun HomeScreen(
    onNavigateToDraw: (Any?) -> Unit,
    onValueSelected: (Int) -> Unit) {

    val viewModel: HomeViewModel = viewModel()

    var quantity by remember { mutableStateOf(1) }
    var minValue by remember { mutableStateOf(1) }
    var maxValue by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .padding(top = 50.dp)
            .verticalScroll(rememberScrollState()),
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
                .padding(start = 25.dp, end = 25.dp)
        )
        {
            Text(
                modifier = Modifier
                    .padding(top = 30.dp),
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
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold,
                )
            )
            Text(
                modifier = Modifier
                    .padding(top = 20.dp),
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
                    modifier = Modifier.padding(end = 20.dp)
                ) {
                    Text(
                        text = "NÚMEROS".uppercase(),
                        Modifier.padding(bottom = 10.dp),
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = FontFamily(Font(R.font.sora))
                        )
                    )

                    var selectNumberDraw by remember { mutableStateOf(false) }
                    Box(
                        modifier = Modifier
                            .background(Color.Gray, shape = RoundedCornerShape(8.dp))
                            .height(85.dp)
                            .width(85.dp)
                            .clickable { selectNumberDraw = true },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = quantity.toString(),
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 40.sp,
                                fontWeight = FontWeight.ExtraBold,
                                fontFamily = FontFamily(Font(R.font.sora))
                            )
                        )

                        val context = LocalContext.current
                        DropdownMenu(
                            expanded = selectNumberDraw,
                            onDismissRequest = { selectNumberDraw = false }
                        ) {
                            (1..5).forEach { number ->
                                DropdownMenuItem(
                                    text = { Text(number.toString()) },
                                    onClick = {
                                        quantity = number
                                        onValueSelected(quantity)
                                        Toast.makeText(context, "Quantidade: $number", Toast.LENGTH_SHORT).show()
                                        selectNumberDraw = false
                                    }
                                )
                            }
                        }
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
                            fontFamily = FontFamily(Font(R.font.sora))
                        )
                    )

                    var expanded by remember { mutableStateOf(false) }
                    Box(
                        modifier = Modifier
                            .background(Color.Gray, shape = RoundedCornerShape(8.dp))
                            .height(85.dp)
                            .width(85.dp)
                            .clickable { expanded = true },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = minValue.toString(),
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 40.sp,
                                fontWeight = FontWeight.ExtraBold,
                                fontFamily = FontFamily(Font(R.font.sora))
                            )
                        )
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            (1..100).forEach { number ->
                                DropdownMenuItem(
                                    text = { Text(number.toString()) },
                                    onClick = {
                                        minValue = number
                                        onValueSelected(minValue)
                                        expanded = false
                                    }
                                )
                            }
                        }
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
                            fontFamily = FontFamily(Font(R.font.sora))
                        )
                    )

                    var expanded by remember { mutableStateOf(false) }
                    Box(
                        modifier = Modifier
                            .background(Color.Gray, shape = RoundedCornerShape(8.dp))
                            .height(85.dp)
                            .width(85.dp)
                            .clickable { expanded = true },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = maxValue.toString(),
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 40.sp,
                                fontWeight = FontWeight.ExtraBold,
                                fontFamily = FontFamily(Font(R.font.sora))
                            )
                        )
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            (minValue..100).forEach { number ->
                                DropdownMenuItem(
                                    text = { Text(number.toString()) },
                                    onClick = {
                                        maxValue = number
                                        onValueSelected(maxValue)
                                        expanded = false
                                    }
                                )
                            }
                        }
                    }
                }
            }

            /**
             * Toggle button, botão sortear e textos explicativos
             */
            var noRepeatNumber by remember { mutableStateOf(true) }
            Row(
                modifier = Modifier.padding(top = 20.dp)
            ) {
                Switch(
                    modifier = Modifier,
                    checked = noRepeatNumber,
                    onCheckedChange = { noRepeatNumber = it },
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
                onClick = {
                    viewModel.drawRandomNumber(quantity, minValue, maxValue, noRepeatNumber)
                    val number = viewModel.randomNumber.value
                    onNavigateToDraw(number)
                },
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
                    .padding(top = 5.dp, bottom = 80.dp)
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
    HomeScreen(
        onNavigateToDraw = {},
        onValueSelected = {}
    )
}