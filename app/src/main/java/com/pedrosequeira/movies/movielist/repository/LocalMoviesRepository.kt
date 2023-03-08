package com.pedrosequeira.movies.movielist.repository

class LocalMoviesRepository : MoviesRepository {

    override fun fetchMovies(): List<String> {
        return emptyList()
    }
}
