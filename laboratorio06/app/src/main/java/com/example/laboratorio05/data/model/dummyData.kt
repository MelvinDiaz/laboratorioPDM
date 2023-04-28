package com.example.laboratorio05.data.model


val name = "Mario"
val category = "Animanada"
val description = "Bien chiva"
val qualification = "10"

val name2 = "Shrek"
val category2 = "Animanada"
val description2 = "Bien chiva"
val qualification2 = "9"

var movies = mutableListOf<MovieModel>(
    MovieModel(name, category, description, qualification),
    MovieModel(name2, category2, description2, qualification2)
)
