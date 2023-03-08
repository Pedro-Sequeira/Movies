package com.pedrosequeira.movies.movielist.repository

internal interface MoviesRepository {

    fun fetchMovies(): List<String>
}
