package com.example.moviemvvm.data.api

import com.example.moviemvvm.data.vo.NewsAppleResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleAppleInterface {

    @GET("v2/everything")
    fun getNewsApple(@Query("q")id:String):Single<NewsAppleResponse>
}
