package com.example.moviemvvm.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviemvvm.R
import com.example.moviemvvm.data.vo.Article
import com.example.moviemvvm.ui.SingleNewsActivity

class NewsAdapter(private var articles: List<Article>):
    RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {
        lateinit var context: Context
        inner class MyViewHolder(view:View):RecyclerView.ViewHolder(view) {
            var tvNews: TextView = view.findViewById(R.id.tvTitleNews)
            var tvSubnews: TextView = view.findViewById(R.id.tvSubnews)
            var tvContent: TextView = view.findViewById(R.id.tvContent)
            var cvNews:CardView = view.findViewById(R.id.listNews)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        context = parent.context
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = articles[position]
        holder.tvNews.text = item.title
        holder.tvSubnews.text = item.author
        holder.tvContent.text = item.content
        holder.cvNews.setOnClickListener {
          context.let {
              val i = Intent(context, SingleNewsActivity::class.java)
              i.putExtra("content", item.content)
              i.putExtra("titles", item.title)
              i.putExtra("author", item.author)
              i.putExtra("published", item.publishedAt)
              i.putExtra("url", item.url)
              context.startActivity(i)
          }
        }
    }

    override fun getItemCount(): Int {
        return  articles.size
    }
}