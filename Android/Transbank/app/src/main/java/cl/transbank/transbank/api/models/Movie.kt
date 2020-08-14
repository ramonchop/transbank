package cl.transbank.transbank.api.models

import java.io.Serializable

data class Movie(
    val title: String,
    val poster_path: String,
    val original_language: String,
    val overview: String
): Serializable