package com.bentley.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class SavedStateViewModel(private var state: SavedStateHandle) : ViewModel() {


//    private val _thumbUpValue: MutableLiveData<Int> = state.getLiveData(THUMB_UP_KeY)
//    val thumbUpValue: LiveData<Int>
//        get() = _thumbUpValue
//
//    private val _thumbDownValue: MutableLiveData<Int> = state.getLiveData(THUMB_DOWN_KeY)
//    val thumbDownValue: LiveData<Int>
//        get() = _thumbDownValue

    companion object {
        private val THUMB_UP_KeY = "thumb_up"
        private val THUMB_DOWN_KeY = "thumb_down"
    }

    fun SavedStateViewModel(savedStateHandle: SavedStateHandle) {
        state = savedStateHandle
    }

    fun getThumUpValue(): LiveData<Int> = state.getLiveData(THUMB_UP_KeY)

    fun saveThumUpValue(value: Int) = state.set(THUMB_UP_KeY, value)

    fun getThumDownValue(): LiveData<Int> = state.getLiveData(THUMB_DOWN_KeY)

    fun saveThumDownValue(value: Int) = state.set(THUMB_DOWN_KeY, value)
}