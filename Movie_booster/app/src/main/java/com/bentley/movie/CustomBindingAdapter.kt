package com.bentley.movie

import android.widget.Button
import android.widget.TextView
import androidx.databinding.BindingAdapter

object CustomBindingAdapter {
    @BindingAdapter("text")
    @JvmStatic
    fun setText(view: TextView, value: Int) {
//    if (TextUtils.isEmpty(text)) {
//        view.text = ""
//    }
        view.text = value.toString()
    }

    @BindingAdapter("status")
    @JvmStatic
    fun updateStatus(view: Button, value: Boolean) {
        view.isSelected = value
    }

}
