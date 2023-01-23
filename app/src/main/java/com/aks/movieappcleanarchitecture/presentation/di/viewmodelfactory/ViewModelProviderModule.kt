package com.aks.movieappcleanarchitecture.presentation.di.viewmodelfactory

import com.aks.movieappcleanarchitecture.domain.usecases.GetBreakingNewsUseCases
import com.aks.movieappcleanarchitecture.domain.usecases.GetNowPlayingMovieUseCases
import com.aks.movieappcleanarchitecture.domain.usecases.GetTopRatedMovieUseCases
import com.aks.movieappcleanarchitecture.presentation.viewmodels.MovieViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ViewModelProviderModule {

    @Provides
    @Singleton
    fun provideViewModelFactory(
        getTopRatedMovieUseCases: GetTopRatedMovieUseCases,
        getNowPlayingMovieUseCases: GetNowPlayingMovieUseCases,
        getBreakingNewsUseCases: GetBreakingNewsUseCases
    ) : MovieViewModelFactory{
        return MovieViewModelFactory(getBreakingNewsUseCases, getNowPlayingMovieUseCases, getTopRatedMovieUseCases)
    }
}