package com.example.moviemvvm.data.vo


import com.google.gson.annotations.SerializedName

data class NewsAppleResponse(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)