package com.example.moviemvvm.data.repository

import com.example.moviemvvm.data.api.ArticleAppleInterface
import com.example.moviemvvm.data.vo.NewsAppleResponse
import io.reactivex.Single
import retrofit2.http.Query

class RemoteNewsRepositoryImpl (private val articleAppleInterface: ArticleAppleInterface): RemoteNewsRepository{
    override fun getNewsApple(q:String): Single<NewsAppleResponse> {
        return articleAppleInterface.getNewsApple(q)
    }
}