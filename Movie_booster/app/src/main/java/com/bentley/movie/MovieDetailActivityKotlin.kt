package com.bentley.movie

import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import com.bentley.movie.SavedStateViewModel.Companion.thumbDownStatusKey
import com.bentley.movie.SavedStateViewModel.Companion.thumbDownValueKey
import com.bentley.movie.SavedStateViewModel.Companion.thumbUpStatuskey
import com.bentley.movie.SavedStateViewModel.Companion.thumbUpValueKey
import com.bentley.movie.databinding.ActivityMovieDetailKotlinBinding
import kotlinx.android.synthetic.main.activity_movie_detail_kotlin.*

class MovieDetailActivityKotlin : AppCompatActivity() {

    private lateinit var viewModel: SavedStateViewModel
    private lateinit var activityMovieDetailKotlinBinding: ActivityMovieDetailKotlinBinding

    lateinit var iv_up: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail_kotlin)

        setUpViewModel()
        setUpButtonSelector()

        btn_reservation.setOnClickListener {
            Toast.makeText(this, "test", Toast.LENGTH_SHORT).show()

        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        if (::viewModel.isInitialized)
            viewModel.saveState()

        super.onSaveInstanceState(outState)
    }

    private fun setUpViewModel() {
        val defaultState = Bundle().apply {
            putInt(thumbUpValueKey, 3)
            putBoolean(thumbUpStatuskey, false)
            putInt(thumbDownValueKey, 1)
            putBoolean(thumbDownStatusKey, false)
        }
        viewModel = ViewModelProvider(this, SavedStateViewModelFactory(application, this, defaultState)).get(SavedStateViewModel::class.java)
        activityMovieDetailKotlinBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie_detail_kotlin)
        activityMovieDetailKotlinBinding.lifecycleOwner = this
        activityMovieDetailKotlinBinding.viewmodel = viewModel
    }

    private fun setUpButtonSelector() {
        iv_thumb_up.setOnClickListener {
            iv_thumb_up.isSelected = !iv_thumb_up.isSelected
            viewModel.saveThumUpStatus(iv_thumb_up.isSelected)


            val thumbUpValue = viewModel.thumbUpValue.value
            val thumbDownValue = viewModel.thumbDownValue.value

            when (iv_thumb_up.isSelected) {
                true -> {
                    viewModel.saveThumUpValue(thumbUpValue!!.plus(1))
                    if (iv_thumb_down.isSelected) {
                        iv_thumb_down.isSelected = false
                        viewModel.saveThumDownStatus(false)
                        viewModel.saveThumDownValue(thumbDownValue!!.minus(1))
                    }
                }
                false ->{
                    viewModel.saveThumUpValue(thumbUpValue!!.minus(1))
                }
            }
        }

        iv_thumb_down.setOnClickListener {
            iv_thumb_down.isSelected = !iv_thumb_down.isSelected
            viewModel.saveThumDownStatus(iv_thumb_down.isSelected)

            val thumbUpValue = viewModel.thumbUpValue.value
            val thumbDownValue = viewModel.thumbDownValue.value

            when (iv_thumb_down.isSelected) {

                true -> {
                    viewModel.saveThumDownValue(thumbDownValue!!.plus(1))
                    if (iv_thumb_up.isSelected) {
                        iv_thumb_up.isSelected = false
                        viewModel.saveThumUpStatus(false)
                        viewModel.saveThumUpValue(thumbUpValue!!.minus(1))
                    }
                }
                false -> viewModel.saveThumDownValue(thumbDownValue!!.minus(1))
            }
        }
    }
}