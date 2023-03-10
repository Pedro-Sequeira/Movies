package com.pedrosequeira.movies.testdata

import com.pedrosequeira.movies.movielist.models.Movie
import com.pedrosequeira.movies.movielist.models.Pagination
import com.pedrosequeira.movies.movielist.repository.MoviesRepository

internal class LocalMoviesRepository(
    private val paginatedMovies: Pagination<Movie> = Pagination()
) : MoviesRepository {

    override suspend fun fetchMovies(page: Int): Pagination<Movie> {
        if (paginatedMovies.totalPages == 0) return Pagination()

        val resultsPerPage = paginatedMovies.totalResults / paginatedMovies.totalPages

        return paginatedMovies.copy(
            page = page,
            results = paginatedMovies.results.subList(
                fromIndex = (page - 1) * resultsPerPage,
                toIndex = page * resultsPerPage
            )
        )
    }
}
