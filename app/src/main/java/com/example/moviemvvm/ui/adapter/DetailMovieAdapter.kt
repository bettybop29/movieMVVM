package com.example.moviemvvm.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.moviemvvm.R
import com.google.android.gms.ads.mediation.Adapter
import com.example.moviemvvm.data.vo.Result
import java.text.FieldPosition


class DetailMovieAdapter(private var results: List<Result>) :
 LinearLayout.Adapter<DetailMovieAdapter.MyViewHolder>(){
  lateinit var context: Context
  inner class MyViewHolder(view: View) : LinearLayout.ViewHolder(view){
    var tvDetailMovie: TextView = view.findViewById(R.id.tvDetailMovie)
  }
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.MyViewHolder{
   val itemView = LayoutInflater.from(parent.context)
    .inflate(R.layout.activity_single_movie, parent, false)
   context = parent.context
   return MovieAdapter.MyViewHolder(itemView)
  }
 override fun onBindViewHolder(holder: MyViewHolder, position: Int){
  val item = results[position]
  holder.tvDetailMovie.text = item.title
 }
}