package cl.transbank.movies.model

data class MovieResult(
    val page: Int,
    val total_results: Int,
    var urlPoster: String,
    val results: ArrayList<Movie>)