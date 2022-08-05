package com.example.moviemvvm.data.repository

import com.example.moviemvvm.data.api.ArticleAppleInterface
import com.example.moviemvvm.data.vo.NewsAppleResponse
import io.reactivex.Single

class RemoteNewsRepositoryImpl (private val articleAppleInterface: ArticleAppleInterface): RemoteNewsRepository{
    override fun getNewsApple(): Single<NewsAppleResponse> {
        return articleAppleInterface.getArticleApple()
    }
}