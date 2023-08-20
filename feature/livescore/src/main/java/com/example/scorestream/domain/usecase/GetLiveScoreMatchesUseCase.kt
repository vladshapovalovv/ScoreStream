package com.example.scorestream.domain.usecase

import com.example.scorestream.domain.entity.Match
import com.example.scorestream.domain.repository.MatchRepository
import javax.inject.Inject

class GetLiveScoreMatchesUseCase @Inject constructor(
    private val repository: MatchRepository
) : suspend () -> List<Match> by repository::get