package com.aks.movieappcleanarchitecture.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GetBreakingNewsResponse(
    @Expose
    @SerializedName("status")
    val status: String?=null,
    @Expose
    @SerializedName("totalResults")
    val totalResults: Int?=null,
    @SerializedName("articles")
    val articles: List<Articles>?=null
) : Serializable
