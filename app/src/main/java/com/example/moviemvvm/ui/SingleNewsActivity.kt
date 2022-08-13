package com.example.moviemvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.moviemvvm.R
import com.example.moviemvvm.databinding.ActivitySingleNewsBinding

class SingleNewsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySingleNewsBinding
    lateinit var title: String
    lateinit var author:String
    lateinit var published:String
    lateinit var content:String
    lateinit var url:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingleNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        content = intent.getStringExtra("content").toString()
        title = intent.getStringExtra("titles").toString()
        author = intent.getStringExtra("author").toString()
        published = intent.getStringExtra("published").toString()
        url = intent.getStringExtra("url").toString()


        Log.d("title", "$title")

        setObserver()
    }
    private fun setObserver(){
        binding.tvDetailNewsAuthor.text = author
        binding.tvDetailJudulNews.text = title
        binding.tvDetailSubNews.text = published
        binding.tvDetailContentNews.text = content
        binding.tvDetailNewsUrl.text = url
    }
}