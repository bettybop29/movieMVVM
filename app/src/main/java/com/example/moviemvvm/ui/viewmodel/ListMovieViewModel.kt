package com.example.moviemvvm.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviemvvm.data.api.TheMovieDBClient
import com.example.moviemvvm.data.repository.RemoteRepository
import com.example.moviemvvm.data.repository.RemoteRepositoryImpl
import com.example.moviemvvm.data.vo.PopularMoviesResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ListMovieViewModel : ViewModel() {
    private val movies = MutableLiveData<PopularMoviesResponse>()
    private val compositeDisposable = CompositeDisposable()
    lateinit var remoteRepository: RemoteRepository

    init {
        remoteRepository = RemoteRepositoryImpl(TheMovieDBClient.getClient())
    }

    fun getMovies(): MutableLiveData<PopularMoviesResponse> = movies
    fun getPopularMovies() {
        compositeDisposable.add(
            remoteRepository.getPopularMovies().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<PopularMoviesResponse>() {
                    override fun onSuccess(t: PopularMoviesResponse) {
                        movies.value = t
                    }

                    override fun onError(e: Throwable) {
                        Log.e("List movie view model", "error = $e")
                    }

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
