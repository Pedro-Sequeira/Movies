package com.pedrosequeira.movies.movielist.presentation

import com.pedrosequeira.movies.movielist.models.MovieListState
import com.pedrosequeira.movies.movielist.repository.MoviesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

internal class MovieListViewModel(
    private val repository: MoviesRepository
) {

    private val _state = MutableStateFlow(MovieListState())
    val state: StateFlow<MovieListState> = _state.asStateFlow()

    fun fetchMovies() {
        _state.update { it.copy(isLoading = true) }
        val movies = repository.fetchMovies()
        _state.update {
            it.copy(
                isLoading = false,
                movies = movies
            )
        }
    }
}
