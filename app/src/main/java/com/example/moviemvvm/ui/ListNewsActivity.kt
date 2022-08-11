package com.example.moviemvvm.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
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

        val button: Button = findViewById(R.id.btnNewsApple)
        button.setOnClickListener {
            Toast.makeText(this, "apple news", Toast.LENGTH_SHORT).show()
//            val apple = println("apple")
            viewModel.getListNews("apple")

        }
        val buttons: Button = findViewById(R.id.btnNewsTesla)
        buttons.setOnClickListener {
            Toast.makeText(this, "tesla news", Toast.LENGTH_SHORT).show()
//            val apple = println("apple")
            viewModel.getListNews("tesla")

        }


        viewModel.getListNews("tesla")

        setObserver()



    }
    private fun setObserver(){
        viewModel.getNews().observe(this, Observer {
            Log.d("List news activity", "response = $it")
            adapter = NewsAdapter(it.articles)
            binding.listNews.adapter = adapter
        })

    }
}