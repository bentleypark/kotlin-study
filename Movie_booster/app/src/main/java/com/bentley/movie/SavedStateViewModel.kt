package com.bentley.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel


class SavedStateViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    companion object {
        val thumbUpValueKey = "thumbUpValue"
        val thumbUpStatuskey = "thumbUpStatus"
        val thumbDownValueKey = "thumbDownValue"
        val thumbDownStatusKey = "thumbDownStatus"
    }

    private val _thumbUpValue: MutableLiveData<Int> = savedStateHandle.getLiveData(thumbUpValueKey)
    val thumbUpValue: LiveData<Int>
        get() = _thumbUpValue

    private val _thumbUpStatus: MutableLiveData<Boolean> = savedStateHandle.getLiveData(thumbUpStatuskey)
    val thumbUpStatus: LiveData<Boolean>
        get() = _thumbUpStatus

    private val _thumbDownValue: MutableLiveData<Int> = savedStateHandle.getLiveData(thumbDownValueKey)
    val thumbDownValue: LiveData<Int>
        get() = _thumbDownValue

    private val _thumbDownStatus: MutableLiveData<Boolean> = savedStateHandle.getLiveData(thumbDownStatusKey)
    val thumbDownStatus: LiveData<Boolean>
        get() = _thumbDownStatus


    fun saveThumUpValue(value: Int) {
        savedStateHandle.set(thumbUpValueKey, value)
    }

    fun saveThumUpStatus(value: Boolean) {
        savedStateHandle.set(thumbUpStatuskey, value)
    }

    fun saveThumDownValue(value: Int) {
        savedStateHandle.set(thumbDownValueKey, value)
    }

    fun saveThumDownStatus(value: Boolean) {
        savedStateHandle.set(thumbDownStatusKey, value)
    }

    fun saveState() {
//        savedStateHandle.set(thumbUpValueKey, _thumbUpValue.value)
//        savedStateHandle.set(thumbDownValueKey, _thumbDownValue.value)
//        savedStateHandle.set(thumbUpStatuskey, _thumbUpStatus.value)
    }
}
