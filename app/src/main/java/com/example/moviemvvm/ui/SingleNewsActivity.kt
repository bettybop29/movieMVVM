package com.example.moviemvvm.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.moviemvvm.databinding.ActivityNewsAppleBinding
import com.example.moviemvvm.databinding.ActivitySingleNewsBinding
import com.example.moviemvvm.ui.viewmodel.ListNewsViewModel

class SingleNewsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySingleNewsBinding
    private val viewModel: ListNewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingleNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
    private fun setObserver(){
        viewModel.getNews().observe(this, Observer {
            binding.tvNews.text = it.status
            binding.tvContent.text = it.totalResults.toString()
            binding.tvSubnews.text = it.articles.toString()
        })
    }
}