package com.example.scorestream.data.repository

import com.example.scorestream.data.converter.MatchConverter
import com.example.scorestream.data.remote.api.SoccerApi
import com.example.scorestream.domain.entity.Match
import com.example.scorestream.domain.repository.MatchRepository
import javax.inject.Inject

class MatchRepositoryImpl @Inject constructor(
    private val soccerApi: SoccerApi,
    private val converter: MatchConverter
) : MatchRepository {
    override suspend fun get(): List<Match> {
        return soccerApi.getLiveScoreMatches().result.map { matchModel ->
            converter.convert(matchModel)
        }
    }
}