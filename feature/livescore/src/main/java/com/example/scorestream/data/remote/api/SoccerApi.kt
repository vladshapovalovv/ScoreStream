package com.example.scorestream.data.remote.api

import com.example.scorestream.data.remote.model.MatchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SoccerApi {

    @GET(".")
    suspend fun getLiveScoreMatches(
        @Query("met") method: String = "Livescore",
    ): MatchResponse
}