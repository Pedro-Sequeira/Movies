package com.pedrosequeira.movies.movielist.models

internal data class MovieListState(
    val isLoading: Boolean = true,
    val paginatedMovies: Pagination<Movie>? = null,
    val error: MovieListError? = null
) {
    fun loading(): MovieListState {
        return this.copy(isLoading = true)
    }

    fun paginatedMovies(paginatedMovies: Pagination<Movie>): MovieListState {
        return this.copy(
            isLoading = false,
            paginatedMovies = paginatedMovies
        )
    }

    fun error(): MovieListState {
        return this.copy(
            isLoading = false,
            error = MovieListError.GenericError
        )
    }

    fun nextPage(): MovieListState {
        return this.copy(
            paginatedMovies = this.paginatedMovies?.copy(
                page = this.paginatedMovies.page.plus(1)
            )
        )
    }

    fun currentPage(): Int {
        return this.paginatedMovies?.page ?: 1
    }
}
