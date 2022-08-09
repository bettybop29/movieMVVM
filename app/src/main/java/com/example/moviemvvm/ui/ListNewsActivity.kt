package com.example.moviemvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviemvvm.R
import com.example.moviemvvm.databinding.ActivityListNewsBinding
import com.example.moviemvvm.ui.adapter.NewsAdapter
import com.example.moviemvvm.ui.viewmodel.ListNewsViewModel

class ListNewsActivity : AppCompatActivity() {
    private val viewModel: ListNewsViewModel by viewModels()
    lateinit var binding: ActivityListNewsBinding
    lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.listNews.layoutManager = LinearLayoutManager(applicationContext)

        viewModel.getListNews()

        setObserver()

    }
    private fun setObserver(){
        viewModel.getNews().observe(this, Observer {
            Log.i("List news activity", "response = $it")
            adapter = NewsAdapter(it.articles)
            binding.listNews.adapter = adapter
        })
    }
}