package com.bentley.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class SavedStateViewModel(private var state: SavedStateHandle) : ViewModel() {


    private val _thumbUpValue: MutableLiveData<String> = getThumUpValue()
    val thumbUpValue: LiveData<String>
        get() = _thumbUpValue

    private val _thumbDownValue: MutableLiveData<String> = getThumDownValue()
    val thumbDownValue: LiveData<String>
        get() = _thumbDownValue

    companion object {
        private val THUMB_UP_KeY = "thumb_up"
        private val THUMB_DOWN_KeY = "thumb_down"
    }

    init {
        _thumbUpValue.value = 3.toString()
        _thumbDownValue.value = 1.toString()

    }

    fun SavedStateViewModel(savedStateHandle: SavedStateHandle) {
        state = savedStateHandle
    }

    fun getThumUpValue(): MutableLiveData<String> = state.getLiveData<String>(THUMB_UP_KeY)

    fun saveThumUpValue(value: Int) = state.set(THUMB_UP_KeY, value.toString())

    fun getThumDownValue(): MutableLiveData<String> = state.getLiveData<String>(THUMB_DOWN_KeY)

    fun saveThumDownValue(value: Int) = state.set(THUMB_DOWN_KeY, value.toString())
}