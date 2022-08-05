package com.example.moviemvvm.ui.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
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
import com.example.moviemvvm.data.vo.ResultX
import com.example.moviemvvm.data.vo.ResultXX
import com.example.moviemvvm.ui.ListMovieTrailerActivity
import com.example.moviemvvm.ui.SingleMovieActivity
import com.example.moviemvvm.ui.listener.OpenTrailer

class MovieNowPlayingAdapter(private var results: List<ResultX>, openTrailer: OpenTrailer):
    RecyclerView.Adapter<MovieNowPlayingAdapter.MyViewHolder>() {
    lateinit var context: Context
    var listener = openTrailer
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var ivNowPosterMovies: ImageView = view.findViewById(R.id.ivNowPosterMovies)
        var tvTitlePlaying: TextView = view.findViewById(R.id.tvTitlePlaying)
        var tvSubPlaying: TextView = view.findViewById(R.id.tvSubPlaying)
        var cvNowPlaying: CardView = view.findViewById(R.id.cvNowPlaying)
        var btnTrailerMovie: TextView = view.findViewById(R.id.btnTrailerMovie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemnowplaying, parent, false)
        context = parent.context
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = results[position]

        holder.tvTitlePlaying.text = item.title
        holder.tvSubPlaying.text = item.releaseDate
        Glide.with(holder.ivNowPosterMovies)
            .load("${TheMovieDBClient.POSTER_BASE_URL}${item.posterPath}")
            .into(holder.ivNowPosterMovies)
//
        holder.cvNowPlaying.setOnClickListener {
            context.let {
                val intent = Intent(context, SingleMovieActivity::class.java)
                intent.putExtra("movie_id", item.id)
                context.startActivity(intent)
            }
        }
        holder.btnTrailerMovie.setOnClickListener {
            listener.openTrailer(item.id)
        }

    }

    override fun getItemCount(): Int {
        return results.size
    }

}