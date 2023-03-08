package com.pedrosequeira.movies

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Rule
import org.junit.Test

class MoviesListTest {

    @get: Rule
    val rule = createAndroidComposeRule<MainActivity>()

    @Test
    fun shouldDisplayMoviesList() {
        val movieListTag = rule.activity.getString(R.string.movies_list_test_tag)

        rule.onNodeWithTag(movieListTag).assertIsDisplayed()
    }
}
