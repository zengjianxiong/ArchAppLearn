package com.zeng.common.base

import androidx.lifecycle.*
import androidx.navigation.NavDirections
import com.zeng.common.utils.Event
import com.zeng.navigation.NavigationCommand

abstract class BaseViewModel() : ViewModel() {

    lateinit var lifecycleOwner: LifecycleOwner


    protected val _snackbarError = MutableLiveData<Event<Any>>()
    val snackbarError: LiveData<Event<Any>>
        get() = _snackbarError

    private val _navigation = MutableLiveData<Event<NavigationCommand>>()
    val navigation: LiveData<Event<NavigationCommand>>
        get() = _navigation


    fun navigate(directions: NavDirections) {
        _navigation.value = Event(NavigationCommand.To(directions))
    }
}