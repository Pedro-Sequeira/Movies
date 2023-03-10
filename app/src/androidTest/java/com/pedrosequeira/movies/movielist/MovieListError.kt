package com.pedrosequeira.movies.movielist

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.pedrosequeira.movies.MainActivity
import com.pedrosequeira.movies.R
import com.pedrosequeira.movies.movielist.di.MovieListViewModelModule
import com.pedrosequeira.movies.movielist.models.Movie
import com.pedrosequeira.movies.movielist.models.Pagination
import com.pedrosequeira.movies.movielist.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(MovieListViewModelModule::class)
internal class MovieListError {

    @Module
    @InstallIn(ViewModelComponent::class)
    object TestModule {

        @Provides
        fun provideRepository(): MoviesRepository {
            return ErrorMoviesRepository()
        }
    }

    @get:Rule(order = 1)
    val hiltTestRule = HiltAndroidRule(this)

    @get: Rule(order = 2)
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun shouldDisplayErrorMessage() {
        val errorTestTag = composeRule.activity.getString(R.string.movie_list_error_tag)

        composeRule.onNodeWithTag(errorTestTag).assertIsDisplayed()
    }
}

private class ErrorMoviesRepository : MoviesRepository {

    override suspend fun fetchMovies(page: Int): Pagination<Movie> {
        throw Throwable()
    }
}
