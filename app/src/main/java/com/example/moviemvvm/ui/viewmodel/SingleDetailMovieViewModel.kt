package com.example.moviemvvm.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviemvvm.data.api.TheMovieDBClient
import com.example.moviemvvm.data.repository.RemoteRepository
import com.example.moviemvvm.data.repository.RemoteRepositoryImpl
import com.example.moviemvvm.data.vo.MovieDetails
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class SingleDetailMovieViewModel : ViewModel() {
    private val detailmovie = MutableLiveData<MovieDetails>()
    private val compositeDisposable = CompositeDisposable()
    lateinit var remoteRepository: RemoteRepository

    init {
        remoteRepository = RemoteRepositoryImpl(TheMovieDBClient.getClient())
    }

    fun getDetailMovie(): MutableLiveData<MovieDetails> = detailmovie
    fun getDetailsMovie(id:String) {
        compositeDisposable.add(
            remoteRepository.getMovieDetails(id).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<MovieDetails>() {
                    override fun onSuccess(t: MovieDetails) {
                        detailmovie.value = t
                    }

                    override fun onError(e: Throwable) {
                        Log.e("Detail Movie", "error = $e")
                    }
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}