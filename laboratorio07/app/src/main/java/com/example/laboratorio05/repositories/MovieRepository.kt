package com.example.laboratorio05.repositories

import com.example.laboratorio05.data.model.MovieModel
import com.example.laboratorio05.data.model.movies

class MovieRepository {

    fun getMovies() = movies

    fun addMovies(movie: MovieModel) = movies.add(movie)

}