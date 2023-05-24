package com.aks.movieappcleanarchitecture.data

import com.aks.movieappcleanarchitecture.data.model.GetBreakingNewsResponse
import com.aks.movieappcleanarchitecture.data.model.GetNowPlayingMovieResponse
import com.aks.movieappcleanarchitecture.data.model.GetTopRatedMovieResponse
import com.aks.movieappcleanarchitecture.data.utils.Constants.API_KEY
import com.aks.movieappcleanarchitecture.data.utils.Constants.API_KEY_MOVIE
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface MovieApis {

    @GET("v2/top-headlines")
    suspend fun getBreakingNews(@Query ("country") country : String = "in",@Query("page") page : Int = 1,@Query("apiKey") apiKey : String = API_KEY) : Response<GetBreakingNewsResponse>

    @GET
    suspend fun getNowPlayingMovie(@Url url: String, @Query("api_key") apiKey : String = API_KEY_MOVIE,@Query("page") page: Int = 1) : Response<GetNowPlayingMovieResponse>

    @GET
    suspend fun getTopRatedMovie(@Url url: String, @Query("api_key") apiKey: String, @Query("page") page: Int = 1) : Response<GetTopRatedMovieResponse>
}