package com.example.moviemvvm.data.repository

import com.example.moviemvvm.data.vo.NewsAppleResponse
import io.reactivex.Single

interface RemoteNewsRepository {
    fun getNewsApple():Single<NewsAppleResponse>
}