package com.aks.movieappcleanarchitecture.data.repo.datasource

import com.aks.movieappcleanarchitecture.data.model.GetBreakingNewsResponse
import com.aks.movieappcleanarchitecture.data.model.GetNowPlayingMovieResponse
import com.aks.movieappcleanarchitecture.data.model.GetTopRatedMovieResponse
import okhttp3.ResponseBody
import retrofit2.Response

interface RemoteDataSource {

    suspend fun getBreakingNews(pageNum : Int) : Response<GetBreakingNewsResponse>

    suspend fun getNowPlayingMovie(pageNum: Int) : Response<GetNowPlayingMovieResponse>

    suspend fun getTopRatedMovie(pageNum: Int) : Response<GetTopRatedMovieResponse>
}