package com.example.scorestream.navigation

import WebViewScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.scorestream.ui.GreetingScreen
import com.example.scorestream.ui.LiveScoreScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.GreetingScreen.route
    ) {
        composable(
            route = Route.GreetingScreen.route
        ) {
            GreetingScreen {
                navController.navigate(Route.LiveScoreScreen.route)
            }
        }
        composable(
            route = Route.LiveScoreScreen.route
        ) {
            LiveScoreScreen {
                navController.navigate(Route.WebViewScreen.route)
            }
        }
        composable(
            route = Route.WebViewScreen.route
        ) {
            WebViewScreen()
        }
    }
}