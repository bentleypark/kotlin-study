package com.bentley.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import com.bentley.movie.databinding.ActivityMovieDetailKotlinBinding
import kotlinx.android.synthetic.main.activity_movie_detail_kotlin.*

class MovieDetailActivityKotlin : AppCompatActivity(R.layout.activity_movie_detail_kotlin) {

    private lateinit var viewModel: SavedStateViewModel
    private lateinit var activityMovieDetailKotlinBinding: ActivityMovieDetailKotlinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpButtonSelector()
        setUpViewModel()
    }

    private fun setUpViewModel() {
        viewModel = ViewModelProvider(this, SavedStateViewModelFactory(application, this)).get(SavedStateViewModel::class.java)
        activityMovieDetailKotlinBinding = DataBindingUtil.setContentView(this,R.layout.activity_movie_detail_kotlin)
        activityMovieDetailKotlinBinding.viewmodel = viewModel
    }

    private fun setUpButtonSelector() {
        iv_thumb_up.setOnClickListener {
            iv_thumb_up.isSelected = !iv_thumb_up.isSelected
            val value = viewModel.thumbUpValue.value?.toInt()
            if (value != null) {
                viewModel.saveThumUpValue( value + 1)
            }
        }

        iv_thumb_down.setOnClickListener {
            iv_thumb_down.isSelected = !iv_thumb_down.isSelected
            val value = viewModel.thumbDownValue.value?.toInt()
            if (value != null) {
                viewModel.saveThumDownValue( value + 1)
            }
        }
    }
}