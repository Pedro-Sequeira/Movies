package com.pedrosequeira.movies.testdata

import com.pedrosequeira.movies.movielist.models.Movie
import com.pedrosequeira.movies.movielist.models.Pagination
import com.pedrosequeira.movies.movielist.repository.MoviesRepository
import kotlinx.coroutines.delay

internal class DelayedMoviesRepository : MoviesRepository {

    override suspend fun fetchMovies(page: Int): Pagination<Movie> {
        delay(1_000)
        return Pagination()
    }
}
