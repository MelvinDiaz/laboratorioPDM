package com.example.laboratorio05.ui.movie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.laboratorio05.data.model.MovieModel
import com.example.laboratorio05.repositories.MovieRepository
import com.example.laboratorio05.MovieReviewerApplication

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {
    var name = MutableLiveData("")
    var description = MutableLiveData("")
    var category = MutableLiveData("")
    var qualification = MutableLiveData("")
    var status = MutableLiveData("")

    fun getMovies() = repository.getMovies()
    fun addMovies(movie: MovieModel) = repository.addMovies(movie)


    private fun validateData(): Boolean {
        when {
            name.value.isNullOrEmpty() -> return false
            description.value.isNullOrEmpty() -> return false
            category.value.isNullOrEmpty() -> return false
            qualification.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun createMovie() {
        if (!validateData()) {
            status.value = WRONG_INFORMATION
            return
        }

        val movie = MovieModel(
            name.value!!,
            description.value!!,
            category.value!!,
            qualification.value!!
        )
        addMovies(movie)
        status.value = MOVIE_CREATED

    }

    private fun clearData() {
        name.value = ""
        description.value = ""
        category.value = ""
        qualification.value = ""
    }

    fun clearStatus() {
        status.value = INACTIVE
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as MovieReviewerApplication
                MovieViewModel(app.movieRepository)
            }
        }
        const val MOVIE_CREATED = "Movie created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }
}