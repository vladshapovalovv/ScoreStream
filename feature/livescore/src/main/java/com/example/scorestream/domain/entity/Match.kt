package com.example.scorestream.domain.entity

data class Match(
    val id: Int,
    val date: String,
    val time: String,
    val homeTeamName: String,
    val awayTeamName: String,
    val halfTimeResult: String,
    val finalResult: String,
    val currentMatchTime: String,
    val countryName: String,
    val leagueName: String,
    val leagueRound: String,
    val leagueSeason: String,
    val homeTeamLogoUrl: String?,
    val awayTeamLogoUrl: String?,
    val leagueLogoUrl: String?,
    val countryFlagImageUrl: String?
)