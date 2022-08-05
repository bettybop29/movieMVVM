package com.example.moviemvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviemvvm.databinding.ActivityListMovieBinding
import com.example.moviemvvm.ui.adapter.MovieAdapter
import com.example.moviemvvm.ui.viewmodel.ListMovieViewModel

class ListMovieActivity : AppCompatActivity() {
    private val viewModel: ListMovieViewModel by viewModels()

    lateinit var binding: ActivityListMovieBinding
    lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.listMovie.layoutManager = LinearLayoutManager(applicationContext)

        viewModel.getPopularMovies()

        setObserver()
    }

    private fun setObserver() {
        viewModel.getMovies().observe(this, Observer {
            Log.i("list movie activity", "response = $it")
            adapter = MovieAdapter(it.results)
            binding.listMovie.adapter = adapter
        })
    }
}