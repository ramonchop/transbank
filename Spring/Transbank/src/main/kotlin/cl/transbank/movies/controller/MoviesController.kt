package cl.transbank.movies.controller

import cl.transbank.movies.model.MovieResult
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.Request
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("movies/top_rated")
open class MoviesController {
    private val LOG = LoggerFactory.getLogger(MoviesController::class.java)

    @Value("\${cl.transbank.movies.top_rated}")
    private lateinit var urlTopRated : String

    @Value("\${cl.transbank.movies.top_rated.photo_path}")
    private lateinit var urlPathPhoto : String


    private val client = OkHttpClient()
    private val gsonBuilder = GsonBuilder()

    @GetMapping
    open fun getTopRated(): MovieResult?{
        try{
            val request = Request.Builder()
            .url(urlTopRated)
            .build()
            val response = client.newCall(request).execute()
            val json = gsonBuilder.create().
            fromJson<MovieResult>(response.body?.string(), MovieResult::class.java)
            json.urlPoster = urlPathPhoto
            return json

        }catch(e: Exception){
            LOG.error(e.message, e)
        }
        return null
    }
}