package com.numberpicker.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.numberpicker.ui.screens.draw.DrawScreen
import com.numberpicker.ui.screens.home.HomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                onNavigateToDraw = { numbers ->
                    val numbersList = when (numbers) {
                        is List<*> -> numbers.filterIsInstance<Int>()
                        is Int -> listOf(numbers)
                        else -> emptyList()
                    }
                    val numbersString = numbersList.joinToString(",")
                    navController.navigate("draw/$numbersString")
                },
                onValueSelected = {}
            )
        }
        composable("draw/{numbers}") { backStackEntry ->
            val numbersString = backStackEntry.arguments?.getString("numbers")
            val number = numbersString
                ?.split(",")
                ?.mapNotNull { it.toIntOrNull() }
            DrawScreen(
                number = number,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
