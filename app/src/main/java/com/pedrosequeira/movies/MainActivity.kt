package com.pedrosequeira.movies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.pedrosequeira.movies.movielist.repository.LocalMoviesRepository
import com.pedrosequeira.movies.movielist.presentation.MovieListScreen
import com.pedrosequeira.movies.movielist.presentation.MovieListViewModel
import com.pedrosequeira.movies.ui.theme.MoviesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val repository = LocalMoviesRepository()
                    val viewModel = MovieListViewModel(repository)
                    MovieListScreen(viewModel)
                }
            }
        }
    }
}

