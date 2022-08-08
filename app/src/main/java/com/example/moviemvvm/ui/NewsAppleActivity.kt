package com.example.moviemvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviemvvm.databinding.ActivityNewsAppleBinding
import com.example.moviemvvm.ui.adapter.NewsAdapter
import com.example.moviemvvm.ui.viewmodel.ListNewsViewModel

class NewsAppleActivity : AppCompatActivity() {
    private val viewModel: ListNewsViewModel by viewModels()
    lateinit var binding: ActivityNewsAppleBinding
    lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsAppleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.listnews.layoutManager = LinearLayoutManager(applicationContext)
        viewModel.getNewsApple()
        setObserver()
    }
    private fun setObserver() {
        viewModel.getNews().observe(this, Observer {
            Log.d("list News activity", "response = $it")
            adapter = NewsAdapter(it.articles)
            binding.listnews.adapter = adapter
        })
    }
}