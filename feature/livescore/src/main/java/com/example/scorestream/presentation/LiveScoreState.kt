package com.example.scorestream.presentation

import androidx.compose.runtime.Composable

sealed interface LiveScoreState {

    data object Initial : LiveScoreState

    data object Loading : LiveScoreState

    data class Content(val matches: List<com.example.scorestream.domain.entity.Match>) :
        LiveScoreState

    data object Empty : LiveScoreState

    data class Error(val message: String) : LiveScoreState

    @Composable
    fun onInitial(action: @Composable () -> Unit): LiveScoreState {
        if (this is Initial) { action() }
        return this
    }

    @Composable
    fun onLoading(action: @Composable () -> Unit): LiveScoreState {
        if (this is Loading) { action() }
        return this
    }

    @Composable
    fun onContent(action: @Composable (matches: List<com.example.scorestream.domain.entity.Match>) -> Unit): LiveScoreState {
        if (this is Content) { action(this.matches) }
        return this
    }

    @Composable
    fun onEmpty(action: @Composable () -> Unit): LiveScoreState {
        if (this is Empty) { action() }
        return this
    }

    @Composable
    fun onError(action: @Composable (message: String) -> Unit): LiveScoreState {
        if (this is Error) { action(this.message) }
        return this
    }
}

