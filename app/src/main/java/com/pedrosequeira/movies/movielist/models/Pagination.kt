package com.pedrosequeira.movies.movielist.models

data class Pagination<T>(
    val page: Int = 1,
    val results: List<T> = emptyList(),
    val totalResults: Int = 0,
    val totalPages: Int = 0
)
