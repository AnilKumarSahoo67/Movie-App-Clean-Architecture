package com.aks.movieappcleanarchitecture.data.repo.datasource

import okhttp3.ResponseBody
import retrofit2.Response

interface RemoteDataSource {

    suspend fun getBreakingNews(pageNum : Int) : Response<ResponseBody>

    suspend fun getNowPlayingMovie(pageNum: Int) : Response<ResponseBody>

    suspend fun getTopRatedMovie(pageNum: Int) : Response<ResponseBody>
}