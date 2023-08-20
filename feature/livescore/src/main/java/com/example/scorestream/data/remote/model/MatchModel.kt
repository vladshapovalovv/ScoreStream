package com.example.scorestream.data.remote.model

import com.google.gson.annotations.SerializedName

data class MatchModel(
    @SerializedName("event_key")
    val eventKey: Int = 0,
    @SerializedName("event_date")
    val eventDate: String = "",
    @SerializedName("event_time")
    val eventTime: String = "",
    @SerializedName("event_home_team")
    val eventHomeTeam: String = "",
    @SerializedName("home_team_key")
    val homeTeamKey: Int = 0,
    @SerializedName("event_away_team")
    val eventAwayTeam: String = "",
    @SerializedName("away_team_key")
    val awayTeamKey: Int = 0,
    @SerializedName("event_halftime_result")
    val eventHalftimeResult: String = "",
    @SerializedName("event_final_result")
    val eventFinalResult: String = "",
    @SerializedName("event_ft_result")
    val eventFtResult: String = "",
    @SerializedName("event_penalty_result")
    val eventPenaltyResult: String = "",
    @SerializedName("event_status")
    val eventStatus: String = "",
    @SerializedName("country_name")
    val countryName: String = "",
    @SerializedName("league_name")
    val leagueName: String = "",
    @SerializedName("league_key")
    val leagueKey: Int = 0,
    @SerializedName("league_round")
    val leagueRound: String = "",
    @SerializedName("league_season")
    val leagueSeason: String = "",
    @SerializedName("event_live")
    val eventLive: String = "",
    @SerializedName("event_stadium")
    val eventStadium: String = "",
    @SerializedName("event_referee")
    val eventReferee: String = "",
    @SerializedName("home_team_logo")
    val homeTeamLogo: String? = "",
    @SerializedName("away_team_logo")
    val awayTeamLogo: String? = "",
    @SerializedName("event_country_key")
    val eventCountryKey: Int = 0,
    @SerializedName("league_logo")
    val leagueLogo: String = "",
    @SerializedName("country_logo")
    val countryLogo: String = "",
    @SerializedName("event_home_formation")
    val eventHomeFormation: String = "",
    @SerializedName("event_away_formation")
    val eventAwayFormation: String = "",
    @SerializedName("fk_stage_key")
    val fkStageKey: String = "",
    @SerializedName("stage_name")
    val stageName: String = "",
    @SerializedName("league_group")
    val leagueGroup: String? = "",
    @SerializedName("goalscorers")
    val goalscorers: List<GoalScorer> = emptyList(),
    @SerializedName("substitutes")
    val substitutes: List<Substitute> = emptyList(),
    @SerializedName("cards")
    val cards: List<Card> = emptyList(),
    @SerializedName("lineups")
    val lineups: Lineups,
    @SerializedName("statistics")
    val statistics: List<Statistic> = emptyList()
)

data class GoalScorer(
    val time: String,
    val homeScorer: String,
    val score: String,
    val awayScorer: String
)

data class Card(
    val time: String,
    val homeFault: String,
    val card: String,
    val awayFault: String
)

data class Substitute(
    val time: String,
    val homeScorer: SubstitutionPlayer,
    val score: String,
    val awayScorer: List<Any>
)

data class SubstitutionPlayer(
    val inPlayer: String,
    val outPlayer: String
)

data class Lineups(
    val homeTeam: TeamLineup,
    val awayTeam: TeamLineup
)

data class TeamLineup(
    val startingLineups: List<Player> = emptyList(),
    val substitutes: List<Player> = emptyList(),
    val coaches: List<Coach> = emptyList()
)

data class Player(
    val player: String,
    val playerNumber: String,
    val playerCountry: String?
)

data class Coach(
    val coach: String,
    val coachCountry: String?
)

data class Statistic(
    val type: String,
    val home: String,
    val away: String
)
