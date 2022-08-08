package com.example.moviemvvm.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviemvvm.R
import com.example.moviemvvm.data.vo.Article

class NewsAdapter (private var result: List<Article>):
RecyclerView.Adapter<NewsAdapter.MyViewHolder>(){
    lateinit var context: Context
    inner class MyViewHolder(view:View): RecyclerView.ViewHolder(view) {
        var tvNews: TextView = view.findViewById(R.id.tvNews)
        var tvSubnews: TextView = view.findViewById(R.id.tvSubnews)
        var tvContent: TextView = view.findViewById(R.id.tvContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val itemView = LayoutInflater.from(parent.context)
           .inflate(R.layout.item_news, parent, false)
        context = parent.context
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = result[position]
        holder.tvNews.text = item.title
        holder.tvSubnews.text = item.author
        holder.tvContent.text = item.content
    }

    override fun getItemCount(): Int {
        return result.size
    }
}