package com.example.moviemvvm.data.repository

import com.example.moviemvvm.data.vo.NewsAppleResponse
import io.reactivex.Single
import retrofit2.http.Query

interface RemoteNewsRepository {
    fun getNewsApple(q:String):Single<NewsAppleResponse>
}