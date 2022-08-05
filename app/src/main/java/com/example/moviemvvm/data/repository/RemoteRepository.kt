package com.example.moviemvvm.data.repository

import com.example.moviemvvm.data.vo.*
import io.reactivex.Single

interface RemoteRepository {
    fun getPopularMovies():Single<PopularMoviesResponse>
    fun getMovieDetails(id:String):Single<MovieDetails>
    fun getNowPlayingMovies():Single<NowPlayingResponse>
    fun getTrailerMovies(id: String):Single<MovieTrailerResponse>
}
