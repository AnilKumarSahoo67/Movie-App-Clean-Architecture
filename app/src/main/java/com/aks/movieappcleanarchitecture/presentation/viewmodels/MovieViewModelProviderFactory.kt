package com.aks.movieappcleanarchitecture.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aks.movieappcleanarchitecture.domain.usecases.GetBreakingNewsUseCases
import com.aks.movieappcleanarchitecture.domain.usecases.GetNowplayingMovieUseCases
import com.aks.movieappcleanarchitecture.domain.usecases.GetTopRatedMovieUseCases

class MovieViewModelProviderFactory(
    private val topRatedMovieUseCases: GetTopRatedMovieUseCases,
    private val nowplayingMovieUseCases: GetNowplayingMovieUseCases,
    private val getBreakingNewsUseCases: GetBreakingNewsUseCases
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(
            topRatedMovieUseCases, nowplayingMovieUseCases, getBreakingNewsUseCases
        ) as T
    }
}