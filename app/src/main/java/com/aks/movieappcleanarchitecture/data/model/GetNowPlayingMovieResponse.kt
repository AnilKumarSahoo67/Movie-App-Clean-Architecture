package com.aks.movieappcleanarchitecture.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GetNowPlayingMovieResponse(
    @Expose
    @SerializedName("page")
    val page: Int,
    @Expose
    @SerializedName("results")
    val results: List<Results>,
    @Expose
    @SerializedName("total_pages")
    val total_pages: Int,
    @Expose
    @SerializedName("total_results")
    val total_results: Int

)
