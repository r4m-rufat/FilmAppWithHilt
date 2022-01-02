package com.codingwithrufat.dihilt.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codingwithrufat.dihilt.R
import com.codingwithrufat.dihilt.models.ResponseItem

class RecyclerViewAdapter(context: Context): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private val context = context
    private var tvShows: List<ResponseItem>? = null

    fun updateTvShowList(tvShows: List<ResponseItem>){
        this.tvShows = tvShows
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_film_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.filmName.text = tvShows!![position].originalTitle
        Glide.with(context).load("https://image.tmdb.org/t/p/w500${tvShows!![position].backdropPath}").into(holder.filmImage)
    }

    override fun getItemCount(): Int {
        if (tvShows != null){
            return tvShows?.size!!
        }
        return 0
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val filmName = itemView.findViewById<TextView>(R.id.filmName)
        val filmImage = itemView.findViewById<ImageView>(R.id.filmImage)

    }

}