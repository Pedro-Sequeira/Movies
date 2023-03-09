package com.pedrosequeira.movies.movielist.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import com.pedrosequeira.movies.R

@Composable
internal fun LoadingComponent() {
    CircularProgressIndicator(
        modifier = Modifier
            .fillMaxSize()
            .testTag(stringResource(R.string.loading_test_tag))
    )
}
