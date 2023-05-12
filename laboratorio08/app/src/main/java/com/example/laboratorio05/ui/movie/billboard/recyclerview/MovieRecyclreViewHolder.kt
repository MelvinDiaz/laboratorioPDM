package com.example.laboratorio05.ui.movie.billboard.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio05.data.model.MovieModel
import com.example.laboratorio05.databinding.MovieItemBinding

class MovieRecyclreViewHolder(private val binding: MovieItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: MovieModel, clickListener: (MovieModel) -> Unit) {
        binding.movieItemTitle.text = movie.name
        binding.movieItemQualification.text = movie.qualification.toString()
        binding.movieItemCardView.setOnClickListener {
            clickListener(movie)
        }
    }
}