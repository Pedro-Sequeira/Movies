package com.pedrosequeira.movies

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.pedrosequeira.movies.movielist.di.MovieListViewModelModule
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
internal class MoviesListTest {

    @Module
    @InstallIn(ViewModelComponent::class)
    object TestModule {

        @Provides
        fun provideRepository(): MoviesRepository {
            val moviesList = mutableListOf<String>()
            for (i in 1..10) {
                moviesList.add("Movie $i")
            }
            return LocalMoviesRepository(moviesList)
        }
    }

    @get:Rule(order = 1)
    val hiltTestRule = HiltAndroidRule(this)

    @get: Rule(order = 2)
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun shouldDisplayMovieList() {
        val movieListTestTag = composeRule.activity.getString(R.string.movies_list_test_tag)

        composeRule.onNodeWithTag(movieListTestTag).assertIsDisplayed()
    }
}
