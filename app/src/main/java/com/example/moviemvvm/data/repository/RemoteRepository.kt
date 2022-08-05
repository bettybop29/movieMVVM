package com.example.moviemvvm.data.repository

import com.example.moviemvvm.data.vo.MovieDetails
import com.example.moviemvvm.data.vo.MovieTrailerResponse
import com.example.moviemvvm.data.vo.NowPlayingResponse
import com.example.moviemvvm.data.vo.PopularMoviesResponse
import io.reactivex.Single

interface RemoteRepository {
    fun getPopularMovies():Single<PopularMoviesResponse>
    fun getMovieDetails(id:String):Single<MovieDetails>
    fun getNowPlayingMovies():Single<NowPlayingResponse>
    fun getTrailerMovies(id: String):Single<MovieTrailerResponse>
}
