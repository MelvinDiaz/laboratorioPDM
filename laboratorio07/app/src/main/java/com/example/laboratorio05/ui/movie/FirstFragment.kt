package com.example.laboratorio05.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.laboratorio05.R
import com.example.laboratorio05.databinding.FragmentFirstBinding
import com.example.laboratorio05.ui.movie.MovieViewModel

class firstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.FloatingButton.setOnClickListener{
            it.findNavController().navigate(R.id.action_firstFragment2_to_addMovieFragment2)
        }
        binding.cardViewMovie.setOnClickListener{
            it.findNavController().navigate(R.id.action_firstFragment2_to_movieFragment2)
        }

    }

    }