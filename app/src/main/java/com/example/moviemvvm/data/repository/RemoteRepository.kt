package com.example.moviemvvm.data.repository

import com.example.moviemvvm.data.vo.MovieDetails
import com.example.moviemvvm.data.vo.PopularMoviesResponse
import io.reactivex.Single

interface RemoteRepository {
    fun getPopularMovies():Single<PopularMoviesResponse>
    fun getMovieDetails():Single<MovieDetails>
}
