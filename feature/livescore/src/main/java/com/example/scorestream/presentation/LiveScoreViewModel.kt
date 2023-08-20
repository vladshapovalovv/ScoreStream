package com.example.scorestream.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.scorestream.domain.usecase.GetLiveScoreMatchesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class LiveScoreViewModel @Inject constructor(
    private val getLiveScoreMatchesUseCase: GetLiveScoreMatchesUseCase
) : ViewModel() {

    private val _liveScoreState = MutableStateFlow<LiveScoreState>(LiveScoreState.Initial)
    val liveScoreState: StateFlow<LiveScoreState> = _liveScoreState

    fun getMatches() {
        viewModelScope.launch {
            _liveScoreState.emit(LiveScoreState.Loading)

            try {
                val matches = getLiveScoreMatchesUseCase.invoke()
                if (matches.isEmpty()) {
                    _liveScoreState.emit(LiveScoreState.Empty)
                } else {
                    _liveScoreState.emit(LiveScoreState.Content(matches))
                }

            } catch (e: IOException) {
                _liveScoreState.emit(LiveScoreState.Error(e.message.toString()))

            } catch (e: HttpException) {
                _liveScoreState.emit(LiveScoreState.Error(e.message.toString()))
            }
        }
    }
}