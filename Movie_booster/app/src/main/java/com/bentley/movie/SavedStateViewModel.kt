package com.bentley.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SavedStateViewModel : ViewModel() {


    private val _thumbUpValue: MutableLiveData<String> = MutableLiveData("3")
    val thumbUpValue: LiveData<String>
        get() = _thumbUpValue

    private val _thumbDownValue: MutableLiveData<String> = MutableLiveData("1")
    val thumbDownValue: LiveData<String>
        get() = _thumbDownValue


    fun saveThumUpValue(value: Int) {
        _thumbUpValue.value = value.toString()
    }

    fun saveThumDownValue(value: Int) {
        _thumbDownValue.value = value.toString()
    }
}
