package com.pedrosequeira.movies.movielist.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.pedrosequeira.movies.movielist.presentation.components.ErrorComponent
import com.pedrosequeira.movies.movielist.presentation.components.LoadingComponent
import com.pedrosequeira.movies.movielist.presentation.components.MovieListComponent

@Composable
internal fun MovieListScreen(
    viewModel: MovieListViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState().value

    viewModel.fetchMovies()

    Box {
        if (state.isLoading) {
            LoadingComponent()
        }

        state.error?.let {
            ErrorComponent {
                viewModel.fetchMovies()
            }
        }

        state.paginatedMovies?.let {
            MovieListComponent(it)
        }
    }
}

