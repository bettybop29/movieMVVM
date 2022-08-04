package com.example.moviemvvm.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviemvvm.R
import com.example.moviemvvm.data.api.TheMovieDBClient
import com.example.moviemvvm.data.vo.Result
import com.example.moviemvvm.ui.SingleMovieActivity


class MovieAdapter(private var results: List<Result>) :
    RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {
    lateinit var context:Context
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var ivMovie: ImageView = view.findViewById(R.id.ivMovie)
        var tvMovieTitle: TextView = view.findViewById(R.id.tvMovieTitle)
        var tvSubtitle: TextView = view.findViewById(R.id.tvSubtitle)
        var cvMovie: CardView = view.findViewById(R.id.cvMovie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        context = parent.context
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = results[position]
        holder.tvMovieTitle.text = item.title
        holder.tvSubtitle.text = item.overview

        Glide.with(holder.ivMovie).load("${TheMovieDBClient.POSTER_BASE_URL}${item.posterPath}").into(holder.ivMovie)
        holder.cvMovie.setOnClickListener {
          context.let {
              val intent = Intent(context, SingleMovieActivity::class.java)
              intent.putExtra("movie_id", item.id)
              context.startActivity(intent)
          }
        }
    }

    override fun getItemCount(): Int {
        return results.size
    }
}