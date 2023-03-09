package com.pedrosequeira.movies.movielist.repository

internal interface MoviesRepository {

    suspend fun fetchMovies(): List<String>
}
