package com.pedrosequeira.movies.movielist.repository

import com.pedrosequeira.movies.movielist.models.Movie
import com.pedrosequeira.movies.movielist.models.Pagination
import javax.inject.Inject

internal class MoviesRepositoryImpl @Inject constructor(): MoviesRepository {

    override suspend fun fetchMovies(): Pagination<Movie> {
        val moviesList = mutableListOf<Movie>()
        for (i in 1..1000) {
            moviesList.add(Movie(title = "Movie $i"))
        }
        return Pagination(results = moviesList)
    }
}
