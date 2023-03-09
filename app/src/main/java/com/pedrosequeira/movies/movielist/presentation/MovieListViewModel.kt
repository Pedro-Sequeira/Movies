package com.pedrosequeira.movies.movielist.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedrosequeira.movies.movielist.models.MovieListState
import com.pedrosequeira.movies.movielist.repository.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
internal class MovieListViewModel @Inject constructor(
    private val repository: MoviesRepository
) : ViewModel() {

    private val _state = MutableStateFlow(MovieListState())
    val state: StateFlow<MovieListState> = _state.asStateFlow()

    fun fetchMovies() {
        viewModelScope.launch {
            _state.update { it.loading() }
            val movies = repository.fetchMovies()
            _state.update {
                it.movies(movies)
            }
        }
    }
}
