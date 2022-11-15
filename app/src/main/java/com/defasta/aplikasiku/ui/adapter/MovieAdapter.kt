package com.defasta.aplikasiku.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.defasta.aplikasiku.R
import com.defasta.aplikasiku.data.response.Search
import com.defasta.aplikasiku.ui.screen.RecyclerViewClickListener

internal class MovieAdapter(private var movieList: List<Search>): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    var listener: RecyclerViewClickListener? = null

    internal class MovieViewHolder(view: View): RecyclerView.ViewHolder(view){
        var nama: TextView = view.findViewById(R.id.title)
        var tahun: TextView = view.findViewById(R.id.year)
        var jenis: TextView = view.findViewById(R.id.genre)
        var itemList: ConstraintLayout = view.findViewById(R.id.itemList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.nama.text = movie.title
        holder.tahun.text = movie.year
        holder.jenis.text = movie.type

        holder.itemList.setOnClickListener {
            listener?.onItemMovieClicked(it, movieList[position])
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}