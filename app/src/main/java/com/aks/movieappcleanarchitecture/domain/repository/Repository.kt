package com.aks.movieappcleanarchitecture.domain.repository

import com.aks.movieappcleanarchitecture.data.model.GetBreakingNewsResponse
import com.aks.movieappcleanarchitecture.data.model.GetNowPlayingMovieResponse
import com.aks.movieappcleanarchitecture.data.model.GetTopRatedMovieResponse
import com.aks.movieappcleanarchitecture.data.repo.resource.NetworkResource
import okhttp3.ResponseBody

interface Repository {

    suspend fun getTopRatedMovie(pageNum : Int) : NetworkResource<GetTopRatedMovieResponse>

    suspend fun getNowPlayingMovie(pageNum: Int) : NetworkResource<GetNowPlayingMovieResponse>

    suspend fun getBreakingNews(pageNum: Int) : NetworkResource<GetBreakingNewsResponse>
}