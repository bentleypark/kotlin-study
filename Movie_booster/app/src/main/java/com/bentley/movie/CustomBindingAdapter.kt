package com.bentley.movie

import android.widget.TextView
import androidx.databinding.BindingAdapter

object CustomBindingAdapter {
    @BindingAdapter("text")
    @JvmStatic
    fun setText(view: TextView, text: CharSequence) {
//    if (TextUtils.isEmpty(text)) {
//        view.text = ""
//    }
        view.text = text
    }
}
