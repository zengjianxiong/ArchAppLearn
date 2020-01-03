package com.zeng.common.base

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.zeng.common.utils.Event
import com.zeng.navigation.NavigationCommand

abstract class BaseViewModel : ViewModel() {

    protected val _snackbarError = MutableLiveData<Event<Int>>()
    val snackbarError: LiveData<Event<Int>>
        get() = _snackbarError

    private val _navigation = MutableLiveData<Event<NavigationCommand>>()
    val navigation: LiveData<Event<NavigationCommand>>
        get() = _navigation


    fun navigate(directions: NavDirections) {
        _navigation.value = Event(NavigationCommand.To(directions))
    }
}