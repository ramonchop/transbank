package cl.transbank.transbank.api

import cl.transbank.transbank.api.models.MovieResult
import retrofit2.Call
import retrofit2.http.GET

const val URL_MOVIES_TOP_RATED = "http://192.168.1.86:8080"

interface MoviesTopRatedServicesApi {
    @GET("movies/top_rated")
    fun getMoviesTopRated(): Call<MovieResult>
}