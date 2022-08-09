package com.example.moviemvvm
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.moviemvvm.databinding.ActivityMainBinding
import com.example.moviemvvm.ui.ListMovieActivity
import com.example.moviemvvm.ui.ListNewsActivity
import com.example.moviemvvm.ui.ListNowPlayingActivity


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
        binding.btnNowPlayingMovie.setOnClickListener {
            val intent = Intent(this, ListNowPlayingActivity::class.java)
            startActivity(intent)
        }
        binding.btnTrailerMovie.setOnClickListener {
            val i = Intent(this, ListNewsActivity::class.java)
            startActivity(i)
        }
    }

}