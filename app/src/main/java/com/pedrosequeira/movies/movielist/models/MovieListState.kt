package com.pedrosequeira.movies.movielist.models

internal data class MovieListState(
    val isLoading: Boolean = true,
    val paginatedMovies: Pagination<Movie>? = null,
    val error: MovieListError? = null
) {
    fun loading(): MovieListState {
        return this.copy(isLoading = true)
    }

    fun movies(movies: List<Movie>): MovieListState {
        return this.copy(
            isLoading = false,
            paginatedMovies = Pagination(results = movies)
        )
    }

    fun error(): MovieListState {
        return this.copy(
            isLoading = false,
            error = MovieListError.GenericError
        )
    }
}
