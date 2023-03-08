package com.pedrosequeira.movies.movielist.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import com.pedrosequeira.movies.R

@Composable
internal fun MovieListScreen(
    viewModel: MovieListViewModel
) {
    val state = viewModel.state.collectAsState().value

    viewModel.fetchMovies()

    Box {
        if (state.isLoading) {
            LoadingComponent()
        }

        state.movies?.let {
            MovieListComponent(it)
        }
    }
}

@Composable
private fun LoadingComponent() {
    CircularProgressIndicator(
        modifier = Modifier
            .fillMaxSize()
            .testTag(stringResource(R.string.loading_test_tag))
    )
}

@Composable
private fun MovieListComponent(it: List<String>) {
    LazyColumn(
        Modifier
            .testTag(stringResource(R.string.movies_list_test_tag))
    ) {
        items(it) { movie ->
            Text(
                modifier = Modifier.testTag("movie"),
                text = movie
            )
        }
    }
}
