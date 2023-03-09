package com.pedrosequeira.movies.movielist.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import com.pedrosequeira.movies.R

@Composable
internal fun ErrorComponent(
    onButtonClicked: () -> Unit
) {
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        AlertDialog(
            modifier = Modifier.testTag(stringResource(R.string.movie_list_error_tag)),
            title = {
                Text(stringResource(R.string.error_title))
            },
            text = {
                Text(stringResource(R.string.generic_error_description))
            },
            onDismissRequest = { openDialog.value = false },
            confirmButton = {
                Modifier.clickable {
                    onButtonClicked.invoke()
                }
                Text(stringResource(R.string.cta_retry))
            }
        )
    }
}
