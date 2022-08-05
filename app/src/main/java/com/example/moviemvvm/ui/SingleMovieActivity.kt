package com.example.moviemvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.moviemvvm.data.api.TheMovieDBClient
import com.example.moviemvvm.databinding.ActivitySingleMovieBinding
import com.example.moviemvvm.ui.viewmodel.SingleDetailMovieViewModel

class SingleMovieActivity : AppCompatActivity() {

private lateinit var binding: ActivitySingleMovieBinding
private val viewModel: SingleDetailMovieViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingleMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val movieId = intent.getIntExtra("movie_id", 0)
        viewModel.getDetailsMovie("$movieId")

        setObserver()
    }
    private fun setObserver(){
        viewModel.getDetailMovie().observe(this, Observer {
            binding.tvDetailMovie.text = it.title
            binding.tvDetailOverview.text = it.releaseDate
            binding.tvDetailVote.text = it.tagline
            Glide.with(binding.ivDetailMovie).load("${TheMovieDBClient.POSTER_BASE_URL}${it.posterPath}").into(binding.ivDetailMovie)
        })
    }
}

