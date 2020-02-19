package com.bentley.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import com.bentley.movie.databinding.ActivityMovieDetailBinding
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivityKotlin : AppCompatActivity() {

    private lateinit var activityMovieDetailBinding: ActivityMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMovieDetailBinding = ActivityMovieDetailBinding.inflate(layoutInflater)
        val rootView = activityMovieDetailBinding.root
        setContentView(rootView)

        val vm = ViewModelProvider(this, SavedStateViewModelFactory(application, this))
                .get(SavedStateViewModel::class.java)


        iv_thumb_up.setOnClickListener {
            iv_thumb_up.isSelected = !iv_thumb_up.isSelected
        }

        iv_thumb_down.setOnClickListener {
            iv_thumb_down.isSelected = !iv_thumb_down.isSelected
        }
    }
}