package com.aks.movieappcleanarchitecture.presentation.di.usecases

import com.aks.movieappcleanarchitecture.domain.repository.Repository
import com.aks.movieappcleanarchitecture.domain.usecases.GetBreakingNewsUseCases
import com.aks.movieappcleanarchitecture.domain.usecases.GetNowPlayingMovieUseCases
import com.aks.movieappcleanarchitecture.domain.usecases.GetTopRatedMovieUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {

    @Provides
    @Singleton
    fun provideGetBreakingNewsUseCases(repository: Repository) : GetBreakingNewsUseCases{
        return GetBreakingNewsUseCases(repository)
    }

    @Provides
    @Singleton
    fun provideGetNowPlayingMovieUseCases(repository: Repository) : GetNowPlayingMovieUseCases{
        return GetNowPlayingMovieUseCases(repository)
    }

    @Provides
    @Singleton
    fun providesGetTopRatedMovieUseCase(repository: Repository) : GetTopRatedMovieUseCases{
        return GetTopRatedMovieUseCases(repository)
    }
}