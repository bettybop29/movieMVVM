package com.example.moviemvvm.data.api

import com.example.moviemvvm.data.vo.NewsAppleResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ArticleAppleInterface {

    @GET("newsapi.org/v2/")
    fun getArticleApple():Single<NewsAppleResponse>
}