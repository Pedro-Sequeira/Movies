package com.pedrosequeira.movies.movielist

import com.pedrosequeira.movies.movielist.models.MovieListState
import com.pedrosequeira.movies.movielist.presentation.MovieListViewModel
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
    fun `display an empty movie list`() = runTest {
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
                movies = emptyList()
            )
        )
        assertEquals(expectedStates, collectedStates)
    }
}
