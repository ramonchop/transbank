package cl.transbank.transbank.repository

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import cl.transbank.transbank.api.MoviesTopRatedServicesApi
import cl.transbank.transbank.api.URL_MOVIES_TOP_RATED
import cl.transbank.transbank.api.models.MovieResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MoviesTopRatedRepository(val application: Application){
    val showProgress = MutableLiveData<Boolean>()
    val movieResult = MutableLiveData<MovieResult>()

    private val retrofit = Retrofit.Builder()
        .baseUrl(URL_MOVIES_TOP_RATED)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun showLoading() {
        showProgress.value = true
    }

    private fun hideLoading() {
        showProgress.value = false
    }

    fun fetchMoviesTopRated() {
        showLoading()
        val service = retrofit.create(MoviesTopRatedServicesApi::class.java)

        service.getMoviesTopRated().enqueue(object : Callback<MovieResult>{
            override fun onFailure(call: Call<MovieResult>, t: Throwable) {
                Toast.makeText(application, "Error!!!", Toast.LENGTH_LONG).show()
                hideLoading()
            }

            override fun onResponse(call: Call<MovieResult>, response: Response<MovieResult>) {
                movieResult.value = response.body()
                hideLoading()

            }

        })
    }




}