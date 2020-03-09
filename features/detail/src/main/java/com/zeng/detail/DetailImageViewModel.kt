package com.zeng.detail

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.zeng.common.base.BaseViewModel

class DetailImageViewModel() : BaseViewModel() {

    // PRIVATE DATA
    private val _imageUrl = MutableLiveData<String>()
    val imageUrl: LiveData<String> get() = _imageUrl

    // PUBLIC ACTIONS ---
    fun loadDataWhenFragmentStarts(imageUrl: String) {
        _imageUrl.value = imageUrl
    }
}
