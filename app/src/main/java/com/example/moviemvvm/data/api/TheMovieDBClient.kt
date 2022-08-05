package com.example.moviemvvm.data.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val API_KEY = "b18cb183aac8625fc2832e65dae92f9e"
const val BASE_URL = "https://api.themoviedb.org/3/"



//https://api.themoviedb.org/3/movie/299534?api_key=b18cb183aac8625fc2832e65dae92f9e&language=en-US
//https://api.themoviedb.org/3/movie/popular?api_key=b18cb183aac8625fc2832e65dae92f9e&language=en-US&page=1
//https://api.themoviedb.org/3/
//https://api.themoviedb.org/3/movie/616037/videos?api_key=b18cb183aac8625fc2832e65dae92f9e&language=en-US

object TheMovieDBClient {
//    https://www.themoviedb.org/movie/616037-thor-love-and-thunder#
    val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342/"
    val TRAILER_BASE_URL = "https://www.youtube.com/watch?v="
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
        val okHttpClient:OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
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