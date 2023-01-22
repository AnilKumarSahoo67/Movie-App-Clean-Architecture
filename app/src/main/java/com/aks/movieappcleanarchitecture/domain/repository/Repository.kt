package com.aks.movieappcleanarchitecture.domain.repository

import com.aks.movieappcleanarchitecture.data.resource.NetworkResource
import okhttp3.ResponseBody

interface Repository {

    suspend fun getBreakingNews(pageNum : Int) : NetworkResource<ResponseBody>

    suspend fun getNowPlayingMovie(pageNum: Int) : NetworkResource<ResponseBody>

    suspend fun getTopRatedMovie(pageNum: Int) : NetworkResource<ResponseBody>
}