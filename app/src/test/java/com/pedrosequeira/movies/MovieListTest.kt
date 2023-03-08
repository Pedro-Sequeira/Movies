package com.pedrosequeira.movies

import com.pedrosequeira.movies.movielist.repository.LocalMoviesRepository
import com.pedrosequeira.movies.movielist.models.MovieListState
import com.pedrosequeira.movies.movielist.presentation.MovieListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toCollection
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
internal class MovieListTest {

    @Test
    fun `display an empty movie list`() = runTest {
        val collectedStates = mutableListOf<MovieListState>()
        val expectedStates = emptyList<MovieListState>()

        val viewModel = MovieListViewModel(LocalMoviesRepository())

        val collectingJob = launch(UnconfinedTestDispatcher()) {
            viewModel.state.toCollection(collectedStates)

            viewModel.fetchMovies()

            assertEquals(expectedStates, collectedStates)
        }

        collectingJob.cancel()
    }
}
