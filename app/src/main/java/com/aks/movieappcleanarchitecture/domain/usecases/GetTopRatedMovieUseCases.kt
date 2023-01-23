package com.aks.movieappcleanarchitecture.domain.usecases

import com.aks.movieappcleanarchitecture.domain.repository.Repository

class GetTopRatedMovieUseCases(private val repository: Repository) {
    suspend fun execute(pageNum : Int) =  repository.getTopRatedMovie(pageNum)
}