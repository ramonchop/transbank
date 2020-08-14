package cl.transbank.transbank.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import cl.transbank.transbank.R
import cl.transbank.transbank.adapters.MovieListAdapter
import cl.transbank.transbank.api.models.MovieResult
import cl.transbank.transbank.viewModel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel
    private lateinit var adapter: MovieListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        viewModel.showProgress.observe(this, Observer {
            progressBar.visibility = if (it)
                VISIBLE else GONE

        })

        viewModel.movieResult.observe(this, Observer {
            adapter.setMovieResult(it)
        })

        adapter = MovieListAdapter(this)
        rviewMovieList.layoutManager = LinearLayoutManager(this)
        rviewMovieList.adapter = adapter

        viewModel.fetchMoviesTopRated()


    }
}