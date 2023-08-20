package com.example.scorestream.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.scorestream.presentation.LiveScoreViewModel
import com.example.scorestream.PerformOnLifecycle
import com.example.scorestream.livescore.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LiveScoreScreen(
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    viewModel: LiveScoreViewModel = hiltViewModel(),
    openWebView: () -> Unit
) {

    val liveScoreState by viewModel.liveScoreState.collectAsStateWithLifecycle()

    PerformOnLifecycle(lifecycleOwner = lifecycleOwner, onStart = {
        viewModel.getMatches()
    })

    liveScoreState.onInitial {
        ProgressBar()
    }.onLoading {
        ProgressBar()
    }.onContent { matches ->
        LiveScoreList(matches = matches, onFabClick = openWebView)
    }.onEmpty {
        InfoMessage(msg = stringResource(R.string.no_matches))
    }.onError {
        InfoMessage(msg = it)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LiveScoreList(
    matches: List<com.example.scorestream.domain.entity.Match>,
    scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(),
    onFabClick: () -> Unit
) {
    Scaffold(floatingActionButton = {
        ExtendedFloatingActionButton(onClick = onFabClick) {
            Text(text = stringResource(R.string.open_webview))
        }
    }) {
        val paddingValues = it
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .nestedScroll(scrollBehavior.nestedScrollConnection)
        ) {
            TopAppBar(title = { Text(text = stringResource(R.string.livescore_matches)) }, scrollBehavior = scrollBehavior)
            LazyColumn(
                modifier = Modifier.statusBarsPadding(),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp)
            ) {
                items(items = matches, key = { match -> match.hashCode() }) { match ->
                    MatchCard(match = match)
                }
            }
        }
    }
}

@Composable
private fun ProgressBar() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
fun InfoMessage(msg: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), contentAlignment = Alignment.Center
    ) {
        Text(
            text = msg,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.error,
            textAlign = TextAlign.Center
        )
    }
}

