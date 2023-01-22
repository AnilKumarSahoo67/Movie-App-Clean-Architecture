package com.aks.movieappcleanarchitecture.presentation.di.usecases

import com.aks.movieappcleanarchitecture.domain.repository.Repository
import com.aks.movieappcleanarchitecture.domain.usecases.GetBreakingNewsUseCases
import com.aks.movieappcleanarchitecture.domain.usecases.GetNowplayingMovieUseCases
import com.aks.movieappcleanarchitecture.domain.usecases.GetTopRatedMovieUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetBreakingNewsUseCases(repository: Repository): GetBreakingNewsUseCases {
        return GetBreakingNewsUseCases(repository)
    }

    @Provides
    @Singleton
    fun provideGetNowPlayingMovieUseCases(repository: Repository): GetNowplayingMovieUseCases {
        return GetNowplayingMovieUseCases(repository)
    }

    @Provides
    @Singleton
    fun provideGetTopRatedMovieUseCases(repository: Repository): GetTopRatedMovieUseCases {
        return GetTopRatedMovieUseCases(repository)
    }
}