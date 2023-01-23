package com.aks.movieappcleanarchitecture.data.repo.dataSouceImpl

import com.aks.movieappcleanarchitecture.data.MovieApis
import com.aks.movieappcleanarchitecture.data.repo.datasource.RemoteDataSource
import com.aks.movieappcleanarchitecture.data.utils.Constants.API_KEY
import com.aks.movieappcleanarchitecture.data.utils.Constants.API_KEY_MOVIE
import com.aks.movieappcleanarchitecture.data.utils.Constants.BASE_URL_MOVIE_NOW_PLAYING
import com.aks.movieappcleanarchitecture.data.utils.Constants.BASE_URL_MOVIE_TOP_RATED
import okhttp3.ResponseBody
import retrofit2.Response

class RemoteDataSourceImpl(private val movieApis: MovieApis) : RemoteDataSource {
    override suspend fun getBreakingNews(pageNum: Int): Response<ResponseBody> {
        return movieApis.getBreakingNews("in", pageNum, API_KEY)
    }

    override suspend fun getNowPlayingMovie(pageNum: Int): Response<ResponseBody> {
        return movieApis.getNowPlayingMovie(BASE_URL_MOVIE_NOW_PLAYING, API_KEY_MOVIE,pageNum)
    }

    override suspend fun getTopRatedMovie(pageNum: Int): Response<ResponseBody> {
        return movieApis.getTopRatedMovie(BASE_URL_MOVIE_TOP_RATED, API_KEY_MOVIE,pageNum)
    }
}