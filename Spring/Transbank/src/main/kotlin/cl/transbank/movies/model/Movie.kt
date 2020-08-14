package cl.transbank.movies.model

import com.google.gson.annotations.Expose

data class Movie(
    val title: String,
    val poster_path: String,
    val original_language: String,
    val overview: String
)