package com.pedrosequeira.movies.testdata

import com.pedrosequeira.movies.movielist.models.Movie
import com.pedrosequeira.movies.movielist.models.Pagination
import com.pedrosequeira.movies.movielist.repository.MoviesRepository

internal class LocalMoviesRepository(
    movies: Pagination<Movie> = Pagination()
) : MoviesRepository {

    private val movieList = movies.results.toMutableList()

    override suspend fun fetchMovies(): Pagination<Movie> {
        return Pagination(results = movieList)
    }
}
