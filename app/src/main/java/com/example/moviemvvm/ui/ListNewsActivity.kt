package com.example.moviemvvm.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviemvvm.R
import com.example.moviemvvm.databinding.ActivityListNewsBinding
import com.example.moviemvvm.ui.adapter.NewsAdapter
import com.example.moviemvvm.ui.viewmodel.ListNewsViewModel
import com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar

class ListNewsActivity : AppCompatActivity() {
    private val viewModel: ListNewsViewModel by viewModels()
    lateinit var binding: ActivityListNewsBinding
    lateinit var adapter: NewsAdapter
    lateinit var editText: EditText
    lateinit var input: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.listNews.layoutManager = LinearLayoutManager(applicationContext)



        val btnPopup : Button = binding.btnpopup
        btnPopup.setOnClickListener {
            val bottomSheetDialog = BottomSheetDialog(
                this@ListNewsActivity, com.google.android.material.R.style.Theme_Design_BottomSheetDialog
            )
            Snackbar.make(binding.listNews, "yuyu", Snackbar.LENGTH_SHORT).show()
        }
        //default adapter
        viewModel.getListNews("tesla")
        setObserver()
    }

    private fun setObserver() {
        viewModel.getNews().observe(this, Observer {
            Log.d("List news activity", "response = $it")
            adapter = NewsAdapter(it.articles)
            binding.listNews.adapter = adapter
        })
    }
}