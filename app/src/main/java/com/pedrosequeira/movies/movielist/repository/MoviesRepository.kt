package com.pedrosequeira.movies.movielist.repository

import com.pedrosequeira.movies.movielist.models.Movie
import com.pedrosequeira.movies.movielist.models.Pagination

internal interface MoviesRepository {

    suspend fun fetchMovies(): Pagination<Movie>
}
