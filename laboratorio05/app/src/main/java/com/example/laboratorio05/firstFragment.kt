package com.example.laboratorio05

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController

class firstFragment : Fragment() {

    private lateinit var buttonAdd: Button
    private lateinit var cardViewMovie: CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()

        buttonAdd.setOnClickListener{
            it.findNavController().navigate(R.id.action_firstFragment2_to_addMovieFragment2)
        }
        cardViewMovie.setOnClickListener{
            it.findNavController().navigate(R.id.action_firstFragment2_to_movieFragment2)
        }
    }

    private fun bind(){
        buttonAdd = view?.findViewById(R.id.FloatingButton) as Button
        cardViewMovie = view?.findViewById(R.id.cardViewMovie) as CardView
    }
}