package com.example.moviemvvm.data.repository

enum class Status {
    RUNNING,
    SUCCESS,
    FAILED
}

class NetworkState(val status: Status, val msg: String) {
    companion object {
        val LOADED: NetworkState
        val LOADING: NetworkState
        val ERROR: NetworkState

        init {
            LOADED = NetworkState(Status.SUCCESS, msg = "Success")
            LOADING = NetworkState(Status.RUNNING, msg = "Loading")
            ERROR = NetworkState(Status.FAILED, msg = "Something went wrong")
        }
    }
}