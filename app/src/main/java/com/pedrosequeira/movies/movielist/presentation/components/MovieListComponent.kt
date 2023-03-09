package com.pedrosequeira.movies.movielist.presentation.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import com.pedrosequeira.movies.R

@Composable
internal fun MovieListComponent(movies: List<String>) {
    LazyColumn(
        Modifier
            .testTag(stringResource(R.string.movies_list_test_tag))
    ) {
        items(movies) { movie ->
            Text(
                modifier = Modifier.testTag("movie"),
                text = movie
            )
        }
    }
}
