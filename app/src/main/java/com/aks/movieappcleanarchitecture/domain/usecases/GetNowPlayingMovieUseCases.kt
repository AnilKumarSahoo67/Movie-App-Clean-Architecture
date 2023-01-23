package com.aks.movieappcleanarchitecture.domain.usecases

import com.aks.movieappcleanarchitecture.domain.repository.Repository

class GetNowPlayingMovieUseCases(private val repository: Repository) {
    suspend fun execute(pageNum : Int) = repository.getNowPlayingMovie(pageNum)
}