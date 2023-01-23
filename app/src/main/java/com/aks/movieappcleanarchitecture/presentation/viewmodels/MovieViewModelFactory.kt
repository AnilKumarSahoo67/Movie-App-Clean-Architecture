package com.aks.movieappcleanarchitecture.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aks.movieappcleanarchitecture.domain.usecases.GetBreakingNewsUseCases
import com.aks.movieappcleanarchitecture.domain.usecases.GetNowPlayingMovieUseCases
import com.aks.movieappcleanarchitecture.domain.usecases.GetTopRatedMovieUseCases

class MovieViewModelFactory(
    private val getBreakingNewsUseCases: GetBreakingNewsUseCases,
    private val getNowPlayingMovieUseCases: GetNowPlayingMovieUseCases,
    private val getTopRatedMovieUseCases: GetTopRatedMovieUseCases
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModels(
            getTopRatedMovieUseCases,
            getNowPlayingMovieUseCases,
            getBreakingNewsUseCases
        ) as T
    }
}