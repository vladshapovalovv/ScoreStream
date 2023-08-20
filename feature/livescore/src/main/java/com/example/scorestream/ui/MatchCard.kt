package com.example.scorestream.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.scorestream.domain.entity.Match
import com.example.scorestream.livescore.R
import com.example.scorestream.ui.theme.Blutter
import com.example.scorestream.ui.theme.ScoreStreamTheme

@Composable
fun MatchCard(
    match: Match,
    modifier: Modifier = Modifier
) {

    Card(
        shape = CardDefaults.outlinedShape,
        colors = CardDefaults.outlinedCardColors(),
        border = CardDefaults.outlinedCardBorder()
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            LeagueInfoRow(
                countryFlag = match.countryFlagImageUrl,
                leagueName = match.leagueName,
                leagueRound = match.leagueRound
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                TeamInfoColumn(teamLogo = match.homeTeamLogoUrl, teamName = match.homeTeamName)
                MatchInfoColumn(
                    date = match.date,
                    time = match.time,
                    score = match.finalResult,
                    status = match.currentMatchTime
                )
                TeamInfoColumn(teamLogo = match.awayTeamLogoUrl, teamName = match.awayTeamName)
            }
        }
    }
}

@Composable
private fun TeamInfoColumn(
    teamLogo: String?,
    teamName: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Card(
            modifier = Modifier.size(70.dp),
            border = BorderStroke(2.dp, MaterialTheme.colorScheme.outline),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background)
        ) {
            if (teamLogo != null) {
                AsyncImage(
                    modifier = Modifier
                        .padding(6.dp),
                    model = teamLogo, contentDescription = stringResource(R.string.team_logo),
                    contentScale = ContentScale.Crop
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier.width(120.dp),
            text = teamName, style = MaterialTheme.typography.bodyMedium,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun MatchInfoColumn(
    date: String,
    time: String,
    score: String,
    status: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "$date $time", style = MaterialTheme.typography.bodySmall)
        Text(text = score, fontFamily = Blutter, fontSize = 36.sp)
        Text(text = status, style = MaterialTheme.typography.labelLarge)
    }
}

@Composable
private fun LeagueInfoRow(
    countryFlag: String?,
    leagueName: String,
    leagueRound: String
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        if (countryFlag != null) {
            AsyncImage(
                model = countryFlag,
                contentDescription = stringResource(R.string.country_flag),
                modifier = Modifier.size(20.dp)
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = buildString {
                append(leagueName)
                append(" - ")
                append(leagueRound)
            },
            style = MaterialTheme.typography.labelMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}


@Preview(showBackground = true)
@Composable
fun MatchCardPreview() {
    ScoreStreamTheme {
        Surface {
            MatchCard(
                match = Match(
                    id = 1,
                    date = "2023-08-19",
                    time = "15:30",
                    homeTeamName = "Home Team",
                    awayTeamName = "Away Team",
                    halfTimeResult = "0 - 0",
                    finalResult = "1 - 0",
                    currentMatchTime = "45",
                    countryName = "Country",
                    leagueName = "League",
                    leagueRound = "Round 1",
                    leagueSeason = "2023",
                    homeTeamLogoUrl = "https://apiv2.allsportsapi.com/logo/3085_fulham.jpg",
                    awayTeamLogoUrl = "https://apiv2.allsportsa…/logo/3086_brentford.jpg",
                    leagueLogoUrl = "https://apiv2.allsportsa…s/152_premier-league.png",
                    countryFlagImageUrl = "https://apiv2.allsportsa…o_country/44_england.png"
                )
            )
        }
    }
}