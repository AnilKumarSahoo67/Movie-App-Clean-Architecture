package com.aks.movieappcleanarchitecture.presentation.di.viewmodelfactory

import com.aks.movieappcleanarchitecture.domain.usecases.GetBreakingNewsUseCases
import com.aks.movieappcleanarchitecture.domain.usecases.GetNowplayingMovieUseCases
import com.aks.movieappcleanarchitecture.domain.usecases.GetTopRatedMovieUseCases
import com.aks.movieappcleanarchitecture.presentation.viewmodels.MovieViewModelProviderFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ViewModelProviderFactoryModule {

    @Provides
    @Singleton
    fun provideViewModelProviderFactory(
        topRatedMovieUseCases: GetTopRatedMovieUseCases,
        nowplayingMovieUseCases: GetNowplayingMovieUseCases,
        breakingNewsUseCases: GetBreakingNewsUseCases
    ):MovieViewModelProviderFactory{
        return MovieViewModelProviderFactory(
            topRatedMovieUseCases,
            nowplayingMovieUseCases,
            breakingNewsUseCases
        )
    }
}