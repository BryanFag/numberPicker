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
            HomeScreen(onNavigateToDraw = {
                navController.navigate("draw")
            })
        }
        composable("draw") {
            DrawScreen(onBack = {
                navController.popBackStack()
            })
        }
    }
}
