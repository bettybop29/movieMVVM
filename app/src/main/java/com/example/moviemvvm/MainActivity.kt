package com.example.moviemvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviemvvm.databinding.ActivityMainBinding
import com.example.moviemvvm.ui.ListMovieActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnListMovie.setOnClickListener {
            val intent = Intent(this, ListMovieActivity::class.java)
            startActivity(intent)
        }
    }
}