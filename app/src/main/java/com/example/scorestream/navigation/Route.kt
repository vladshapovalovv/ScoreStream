package com.example.scorestream.navigation

sealed class Route(
    val route: String
){
    data object GreetingScreen : Route(route = "greetingScreen")
    data object LiveScoreScreen : Route(route = "liveScoreScreen")
    data object WebViewScreen : Route(route = "webViewScreen")
}
