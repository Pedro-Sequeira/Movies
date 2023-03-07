package com.pedrosequeira.movies

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource

@Composable
fun MovieListScreen() {
    val movies = emptyList<String>()

    LazyColumn(
        Modifier
            .testTag(stringResource(id = R.string.movies_list_test_tag))
    ) {
        items(movies) { movie ->
            Text(text = movie)
        }
    }
}
