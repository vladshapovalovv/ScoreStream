package com.example.scorestream.data.converter

import com.example.scorestream.data.remote.model.MatchModel
import com.example.scorestream.domain.entity.Match
import javax.inject.Inject

class MatchConverter @Inject constructor() {

    fun convert(from: MatchModel): Match {
        return Match(
            id = from.eventKey,
            date = from.eventDate,
            time = from.eventTime,
            homeTeamName = from.eventHomeTeam,
            awayTeamName = from.eventAwayTeam,
            halfTimeResult = from.eventHalftimeResult,
            finalResult = from.eventFinalResult,
            currentMatchTime = from.eventStatus,
            countryName = from.countryName,
            leagueName = from.leagueName,
            leagueRound = from.leagueRound,
            leagueSeason = from.leagueSeason,
            homeTeamLogoUrl = from.homeTeamLogo,
            awayTeamLogoUrl = from.awayTeamLogo,
            leagueLogoUrl = from.leagueLogo,
            countryFlagImageUrl = from.countryLogo
        )
    }

}