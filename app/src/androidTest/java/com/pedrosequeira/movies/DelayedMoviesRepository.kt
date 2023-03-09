package com.pedrosequeira.movies

import com.pedrosequeira.movies.movielist.repository.MoviesRepository
import kotlinx.coroutines.delay

internal class DelayedMoviesRepository : MoviesRepository {

    override suspend fun fetchMovies(): List<String> {
        delay(1_000)
        return emptyList()
    }
}
