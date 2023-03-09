package com.pedrosequeira.movies.movielist.repository

import javax.inject.Inject

internal class MoviesRepositoryImpl @Inject constructor(): MoviesRepository {

    override suspend fun fetchMovies(): List<String> {
        return emptyList()
    }
}
