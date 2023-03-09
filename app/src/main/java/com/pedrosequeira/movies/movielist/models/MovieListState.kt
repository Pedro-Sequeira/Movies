package com.pedrosequeira.movies.movielist.models

internal data class MovieListState(
    val isLoading: Boolean = true,
    val movies: List<String>? = null,
    val error: MovieListError? = null
) {
    fun loading(): MovieListState {
        return this.copy(isLoading = true)
    }

    fun movies(movies: List<String>): MovieListState {
        return this.copy(
            isLoading = false,
            movies = movies
        )
    }

    fun error(): MovieListState {
        return this.copy(
            isLoading = false,
            error = MovieListError.GenericError
        )
    }
}
