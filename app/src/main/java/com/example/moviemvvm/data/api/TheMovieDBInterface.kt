package com.example.moviemvvm.data.api

import com.example.moviemvvm.data.vo.MovieDetails
import com.example.moviemvvm.data.vo.MovieTrailerResponse
import com.example.moviemvvm.data.vo.NowPlayingResponse
import com.example.moviemvvm.data.vo.PopularMoviesResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface TheMovieDBInterface {

   //https://api.themoviedb.org/3/movie/299534?api_key=b18cb183aac8625fc2832e65dae92f9e&language=en-US
   //https://api.themoviedb.org/3/movie/popular?api_key=b18cb183aac8625fc2832e65dae92f9e&language=en-US&page=1
   //https://api.themoviedb.org/3/
   //https://api.themoviedb.org/3/movie/now_playing?api_key=b18cb183aac8625fc2832e65dae92f9e

   @GET("movie/{movie_id}")
   fun getMovieDetails(@Path("movie_id")id:String): Single<MovieDetails>
   @GET("movie/popular")
   fun getPopularMovies():Single<PopularMoviesResponse>
   @GET("movie/now_playing")
   fun getNowPlayingMovies():Single<NowPlayingResponse>
   @GET("movie/{movie_id}/videos")
   fun getTrailerMovies(@Path("movie_id")id: String):Single<MovieTrailerResponse>
}