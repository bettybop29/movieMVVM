package com.example.moviemvvm.data.repository

import com.example.moviemvvm.data.api.TheMovieDBInterface
import com.example.moviemvvm.data.vo.MovieDetails
import com.example.moviemvvm.data.vo.PopularMoviesResponse
import io.reactivex.Single

class RemoteRepositoryImpl (private val theMovieDBInterface: TheMovieDBInterface): RemoteRepository {
    override fun getPopularMovies(): Single<PopularMoviesResponse> {
        return theMovieDBInterface.getPopularMovies()
    }
    override fun getMovieDetails(): Single<MovieDetails> {
        return theMovieDBInterface.getMovieDetails()
    }
}
