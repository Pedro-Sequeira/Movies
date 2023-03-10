package com.pedrosequeira.movies.movielist.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import com.pedrosequeira.movies.R
import com.pedrosequeira.movies.movielist.models.Movie
import com.pedrosequeira.movies.movielist.models.Pagination

@Composable
internal fun MovieListComponent(paginatedMovies: Pagination<Movie>) {
    LazyColumn(
        Modifier
            .fillMaxSize()
            .testTag(stringResource(R.string.movies_list_test_tag))
    ) {
        items(paginatedMovies.results) { movie ->
            Text(text = movie.title)
        }
    }
}
