package cl.transbank.transbank.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import cl.transbank.transbank.api.models.MovieResult
import cl.transbank.transbank.repository.MoviesTopRatedRepository

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = MoviesTopRatedRepository(application)

    val showProgress : LiveData<Boolean>
    val movieResult : LiveData<MovieResult>

    init {
        this.showProgress = repository.showProgress
        this.movieResult = repository.movieResult
    }

    fun fetchMoviesTopRated() {
        repository.fetchMoviesTopRated()
    }


}