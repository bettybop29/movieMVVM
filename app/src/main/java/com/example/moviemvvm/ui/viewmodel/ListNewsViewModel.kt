package com.example.moviemvvm.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviemvvm.data.api.ArticleAppleDBClient
import com.example.moviemvvm.data.repository.RemoteNewsRepository
import com.example.moviemvvm.data.repository.RemoteNewsRepositoryImpl
import com.example.moviemvvm.data.vo.NewsAppleResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ListNewsViewModel: ViewModel() {
    private val news = MutableLiveData<NewsAppleResponse>()
    private val compositeDisposable = CompositeDisposable()
    lateinit var remoteNewsRepository: RemoteNewsRepository

    init {
        remoteNewsRepository = RemoteNewsRepositoryImpl(ArticleAppleDBClient.getClient())
    }

    fun getNews(): MutableLiveData<NewsAppleResponse> = news
    fun getNewsApple() {
        compositeDisposable.add(
            remoteNewsRepository.getNewsApple().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<NewsAppleResponse>(){
                    override fun onSuccess(t: NewsAppleResponse) {
                        news.value = t
                    }

                    override fun onError(e: Throwable) {
                        Log.e("List News Viewmodel", "error = $e")
                    }

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}