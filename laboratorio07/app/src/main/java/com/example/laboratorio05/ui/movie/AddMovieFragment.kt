package com.example.laboratorio05.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.laboratorio05.data.model.MovieModel
import com.example.laboratorio05.databinding.FragmentAddMovieBinding

class AddMovieFragment : Fragment() {
    private lateinit var binding: FragmentAddMovieBinding
    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddMovieBinding.inflate(inflater, container, false)
        return binding.root
    }


    private fun setViewModel() {
        binding.viewModel = movieViewModel
    }


    private fun observeStatus() {
        movieViewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(MovieViewModel.WRONG_INFORMATION) -> {
                    Log.d("Addingmovie", status)
                    movieViewModel.clearStatus()
                }

                status.equals(MovieViewModel.MOVIE_CREATED) -> {
                    Log.d("Addingmovie", status)
                    Log.d("addingmovie", movieViewModel.getMovies().toString())
                    movieViewModel.clearStatus()
                    findNavController().popBackStack()

                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observeStatus()
    }
}
