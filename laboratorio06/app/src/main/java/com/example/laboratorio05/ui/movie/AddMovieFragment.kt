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
import com.example.laboratorio05.data.model.MovieModel
import com.example.laboratorio05.databinding.FragmentAddMovieBinding

class AddMovieFragment : Fragment() {
    private lateinit var binding: FragmentAddMovieBinding
    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    private lateinit var nameEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var qualificationEditText: EditText
    private lateinit var categoryEditText: EditText
    private lateinit var summitButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddMovieBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nameEditText = binding.nameEditText
        descriptionEditText = binding.descriptionEditText
        qualificationEditText = binding.calificationEditText
        categoryEditText = binding.categoryEditText
        summitButton = binding.submitBtn

        summitButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val description = descriptionEditText.text.toString()
            val qualification = qualificationEditText.text.toString()
            val category = categoryEditText.text.toString()


            val movie = MovieModel(name, description, qualification, category)
            movieViewModel.addMovies(movie)


            Toast.makeText(requireContext(), "Movie added: $name , $description, $qualification , $category",  Toast.LENGTH_SHORT).show()
            Log.d("AddMovieFragment", movieViewModel.getMovies().toString())
        }
    }
}
