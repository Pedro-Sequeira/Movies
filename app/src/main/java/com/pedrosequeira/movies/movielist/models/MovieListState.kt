package com.pedrosequeira.movies.movielist.models

internal data class MovieListState(
    val isLoading: Boolean = true,
    val movies: List<String>? = null
)
