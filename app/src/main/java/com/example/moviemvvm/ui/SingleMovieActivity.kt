package com.example.moviemvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviemvvm.R
import com.example.moviemvvm.databinding.ActivityListMovieBinding

class SingleMovieActivity : AppCompatActivity() {

//    private lateinit var binding: ActivityListMovieBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_movie)
    }
}