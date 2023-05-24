package com.aks.movieappcleanarchitecture.data.model

data class ResponseCheckingModel(
    val breakingNewsResponse: Boolean = false,
    val topRatedMovieResponse: Boolean = false,
    val nowPlayingMovieResponse: Boolean = false
)