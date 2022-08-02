package com.example.moviemvvm.data.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val API_KEY = "b18cb183aac8625fc2832e65dae92f9e"
const val BASE_URL = "https://api.themoviedb.org/3/"

const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"

//https://api.themoviedb.org/3/movie/299534?api_key=b18cb183aac8625fc2832e65dae92f9e&language=en-US
//https://api.themoviedb.org/3/movie/popular?api_key=b18cb183aac8625fc2832e65dae92f9e&language=en-US&page=1
//https://api.themoviedb.org/3/

object TheMovieDBClient {
    fun getClient(): TheMovieDBInterface {

        val requestInterceptor = Interceptor { chain ->
            val url = chain.request()
                .url()
                .newBuilder()
                .addQueryParameter("api_key", API_KEY)
                .build()
            val request = chain.request()
                .newBuilder()
                .url(url)
                .build()

            return@Interceptor chain.proceed(request)
        }
        val okHttpClient:OkHttpClient = okhttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .connectionTimeout(60, TimeUnit.SECONDS)
            .build()
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TheMovieDBInterface::class.java)
    }
}