package com.pedrosequeira.movies.movielist.models

internal sealed class MovieListError {

    object GenericError: MovieListError()
}
