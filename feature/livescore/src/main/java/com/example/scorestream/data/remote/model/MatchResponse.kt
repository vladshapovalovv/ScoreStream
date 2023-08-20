package com.example.scorestream.data.remote.model

data class MatchResponse(
    val success: Int,
    val result: List<MatchModel>
)