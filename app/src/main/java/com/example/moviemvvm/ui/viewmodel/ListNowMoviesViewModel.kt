package com.example.moviemvvm.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviemvvm.data.api.TheMovieDBClient
import com.example.moviemvvm.data.repository.RemoteRepository
import com.example.moviemvvm.data.repository.RemoteRepositoryImpl
import com.example.moviemvvm.data.vo.MovieTrailerResponse
import com.example.moviemvvm.data.vo.NowPlayingResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ListNowMoviesViewModel : ViewModel(){
    private val nowMovies = MutableLiveData<NowPlayingResponse>()
    private val compositeDisposable = CompositeDisposable()
    private val moviesTrailer = MutableLiveData<MovieTrailerResponse>()
    lateinit var remoteRepository: RemoteRepository

    init {
        remoteRepository = RemoteRepositoryImpl(TheMovieDBClient.getClient())
    }
    fun getNowMovies(): MutableLiveData<NowPlayingResponse> = nowMovies
    fun getNowPlayingMovies() {
        compositeDisposable.add(
            remoteRepository.getNowPlayingMovies().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<NowPlayingResponse>(){
                    override fun onSuccess(t: NowPlayingResponse) {
                        nowMovies.value = t
                    }

                    override fun onError(e: Throwable) {
                        Log.e("List Now Movie", "error = $e")
                    }

                })
        )
    }
    fun getTrailerByMovie(): MutableLiveData<MovieTrailerResponse> =moviesTrailer
    fun getTrailerByMovieId(id:String){
        compositeDisposable.add(
            remoteRepository.getTrailerMovies(id).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<MovieTrailerResponse>(){
                    override fun onSuccess(t: MovieTrailerResponse) {
                       moviesTrailer.value = t
                    }

                    override fun onError(e: Throwable) {
                        Log.e("List Now trailer", "error = $e")
                    }
                }
        ))
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
