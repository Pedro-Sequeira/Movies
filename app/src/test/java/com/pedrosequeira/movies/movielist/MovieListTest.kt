package com.pedrosequeira.movies.movielist

import com.pedrosequeira.movies.movielist.models.Movie
import com.pedrosequeira.movies.movielist.models.MovieListError
import com.pedrosequeira.movies.movielist.models.MovieListState
import com.pedrosequeira.movies.movielist.models.Pagination
import com.pedrosequeira.movies.movielist.presentation.MovieListViewModel
import com.pedrosequeira.movies.movielist.repository.MoviesRepository
import com.pedrosequeira.movies.rules.TestDispatcherRule
import com.pedrosequeira.movies.testdata.LocalMoviesRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toCollection
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
internal class MovieListTest {

    @get:Rule
    val testDispatcherRule = TestDispatcherRule()

    @Test
    fun `loading an empty movie list`() = runTest {
        val collectedStates = mutableListOf<MovieListState>()

        val repository = LocalMoviesRepository()
        val viewModel = MovieListViewModel(repository)

        backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
            viewModel.state.toCollection(collectedStates)
        }
        viewModel.fetchMovies()

        val expectedStates = listOf(
            MovieListState(isLoading = true),
            MovieListState(
                isLoading = false,
                paginatedMovies = Pagination()
            )
        )
        assertEquals(expectedStates, collectedStates)
    }

    @Test
    fun `catching the error state`() = runTest {
        val collectedStates = mutableListOf<MovieListState>()

        val repository = ErrorRepository()
        val viewModel = MovieListViewModel(repository)

        backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
            viewModel.state.toCollection(collectedStates)
        }

        viewModel.fetchMovies()

        val expectedStates = listOf(
            MovieListState(isLoading = true),
            MovieListState(
                isLoading = false,
                error = MovieListError.GenericError
            )
        )
        assertEquals(expectedStates, collectedStates)
    }
}

private class ErrorRepository : MoviesRepository {

    override suspend fun fetchMovies(): Pagination<Movie> {
        throw Throwable()
    }
}

