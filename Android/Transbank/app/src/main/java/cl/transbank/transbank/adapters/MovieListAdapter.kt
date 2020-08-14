package cl.transbank.transbank.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.transbank.transbank.R
import cl.transbank.transbank.api.models.MovieResult
import cl.transbank.transbank.view.MovieDetailActivity
import kotlinx.android.synthetic.main.layout_movie_list.view.*

class MovieListAdapter(private val context: Context)
    : RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder>(){

    private var movieResult: MovieResult = MovieResult()

    fun setMovieResult(movieResult: MovieResult){
        this.movieResult = movieResult
        notifyDataSetChanged()
    }

    class MovieListViewHolder(val viewMovie: View): RecyclerView.ViewHolder(viewMovie)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        return MovieListViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.layout_movie_list, parent, false)
        )
    }

    override fun getItemCount() = movieResult.results.size

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        val movie = movieResult.results[position]
        holder.viewMovie.txtTitle.text = movie.title
        holder.viewMovie.setOnClickListener {
            val intent = Intent(context, MovieDetailActivity::class.java).apply {
                putExtra("movie", movie)
                putExtra("pathUrl", movieResult.urlPoster)
            }
            context.startActivity(intent)
        }
    }



}

