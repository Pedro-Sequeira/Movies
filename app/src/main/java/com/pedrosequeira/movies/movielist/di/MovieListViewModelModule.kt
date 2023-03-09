package com.pedrosequeira.movies.movielist.di

import com.pedrosequeira.movies.movielist.repository.MoviesRepository
import com.pedrosequeira.movies.movielist.repository.MoviesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class MovieListViewModelModule {

    @Binds
    abstract fun bindRepository(repository: MoviesRepositoryImpl): MoviesRepository
}
