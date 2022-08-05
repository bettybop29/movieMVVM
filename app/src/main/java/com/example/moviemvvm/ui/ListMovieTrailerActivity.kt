package com.example.moviemvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviemvvm.databinding.ActivityListMovieTrailerBinding

class ListMovieTrailerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListMovieTrailerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListMovieTrailerBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}