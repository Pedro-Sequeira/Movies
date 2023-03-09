package com.pedrosequeira.movies.testdata

import com.pedrosequeira.movies.movielist.repository.MoviesRepository

internal class LocalMoviesRepository(
    movies: List<String> = emptyList()
) : MoviesRepository {

    private val movieList = movies.toMutableList()

    override suspend fun fetchMovies(): List<String> {
        return movieList
    }
}
