package cl.transbank.transbank.api.models

data class MovieResult(
    var urlPoster: String  = String(),
    var results: List<Movie> = ArrayList()
)