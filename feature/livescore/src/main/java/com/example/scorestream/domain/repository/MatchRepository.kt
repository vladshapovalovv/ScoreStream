package com.example.scorestream.domain.repository

import com.example.scorestream.domain.entity.Match

interface MatchRepository {

    suspend fun get(): List<Match>

}