package com.pedrosequeira.movies

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class MoviesListTest {

    @get: Rule
    val rule = createAndroidComposeRule<MainActivity>()

    @Test
    fun shouldDisplayGreeting() {
        rule
            .onNodeWithText("Hello Android!")
            .assertIsDisplayed()
    }
}
