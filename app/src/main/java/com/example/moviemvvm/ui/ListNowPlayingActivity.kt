package com.example.moviemvvm.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviemvvm.R
import com.example.moviemvvm.databinding.ActivityListNowPlayingBinding
import com.example.moviemvvm.databinding.ActivityMainBinding
import com.example.moviemvvm.ui.adapter.MovieNowPlayingAdapter
import com.example.moviemvvm.ui.listener.OpenTrailer
import com.example.moviemvvm.ui.viewmodel.ListNowMoviesViewModel

class ListNowPlayingActivity : AppCompatActivity(),OpenTrailer {
    private  val viewModel: ListNowMoviesViewModel by viewModels()
    lateinit var binding: ActivityListNowPlayingBinding
    lateinit var adapter: MovieNowPlayingAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListNowPlayingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.listPlayingNow.layoutManager = LinearLayoutManager(applicationContext)

        viewModel.getNowPlayingMovies()

        setObserver()
    }
    private fun setObserver() {
        viewModel.getNowMovies().observe(this, Observer {
//            Log.i("List movie now activity", "response = $i")
            adapter = MovieNowPlayingAdapter(it.results, this)

            binding.listPlayingNow.adapter = adapter
        })
        viewModel.getTrailerByMovie().observe(this, Observer {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v="+it.results[0].key ))
            Log.d("List Now trailer", "https://www.youtube.com/watch?v="+it.results[0].key)
            startActivity(i)
        })

    }

    override fun openTrailer(movieId: Int) {
        viewModel.getTrailerByMovieId(movieId.toString())
        Log.d("List Now trailer", "$movieId")

    }


}