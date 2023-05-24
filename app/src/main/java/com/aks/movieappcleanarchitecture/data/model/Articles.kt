package com.aks.movieappcleanarchitecture.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Articles(
    @Expose
    @SerializedName("source")
    val source: Source,
    @Expose
    @SerializedName("author")
    val author: String,
    @Expose
    @SerializedName("title")
    val title: String,
    @Expose
    @SerializedName("description")
    val description: String,
    @Expose
    @SerializedName("url")
    val url: String,
    @Expose
    @SerializedName("urlToImage")
    val urlToImage: String,
    @Expose
    @SerializedName("publishedAt")
    val publishedAt: String,
    @Expose
    @SerializedName("content")
    val content: String
): Serializable