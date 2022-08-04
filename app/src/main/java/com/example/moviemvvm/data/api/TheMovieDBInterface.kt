package com.example.moviemvvm.data.api

import com.example.moviemvvm.data.vo.MovieDetails
import com.example.moviemvvm.data.vo.PopularMoviesResponse
import io.reactivex.Single
import retrofit2.http.GET




interface TheMovieDBInterface {

   //https://api.themoviedb.org/3/movie/299534?api_key=b18cb183aac8625fc2832e65dae92f9e&language=en-US
   //https://api.themoviedb.org/3/movie/popular?api_key=b18cb183aac8625fc2832e65dae92f9e&language=en-US&page=1
   //https://api.themoviedb.org/3/

   @GET("movie/{movie_id}")
//   fun getMovieDetails(@Path("movie_id")id:Int):Single<MovieDetails>
   fun getMovieDetails(): Single<MovieDetails>
//   https://api.themoviedb.org/3/movie/popular?api_key=b18cb183aac8625fc2832e65dae92f9e&language=en-US&page=1
   @GET("movie/popular")
   fun getPopularMovies():Single<PopularMoviesResponse>

//   fun getMovieDetails(): Single<MovieDetails>
}