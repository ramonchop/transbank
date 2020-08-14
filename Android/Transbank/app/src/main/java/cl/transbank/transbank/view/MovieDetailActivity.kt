package cl.transbank.transbank.view

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cl.transbank.transbank.R
import cl.transbank.transbank.api.models.Movie
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        val movie = intent.getSerializableExtra("movie") as Movie
        val path = intent.getStringExtra("pathUrl")
        val moviePhoto = "$path${movie.poster_path}"
        title = movie.title
        Picasso.with(this)
            .load(moviePhoto)
            .placeholder(ColorDrawable(Color.BLACK))
            .error(R.drawable.ic_launcher_background)
            .into(img)

        txtOverview.text = movie.overview

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}