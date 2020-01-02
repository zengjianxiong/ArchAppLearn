package com.zeng.home

import android.util.Log
import androidx.lifecycle.*
import com.zeng.common.base.BaseViewModel
import com.zeng.common.utils.Event
import com.zeng.home.domain.GetTopUsersUseCase
import com.zeng.model.Banner
import com.zeng.model.User
import com.zeng.repository.AppDispatchers
import com.zeng.repository.utils.NetworkBoundResource
import com.zeng.repository.utils.Resource
import io.reactivex.Observable
import kotlinx.coroutines.launch
import kotlinx.coroutines.rx2.rxObservable
import kotlinx.coroutines.withContext

class HomeViewModel(val getTopUsersUseCase: GetTopUsersUseCase, val dispatchers: AppDispatchers) :
    BaseViewModel() {

    private val _users = MediatorLiveData<Resource<List<Banner.Item>>>()
    val users: LiveData<Resource<List<Banner.Item>>>
        get() = _users

    private var userResource: LiveData<Resource<List<Banner.Item>>> = MutableLiveData()

    init {
        getUsers(false)
    }

    fun userRefreshesItems() = getUsers(true)

    fun userClicksOnItem(user: User) {

        Log.d("Tag", user.toString())
        navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(user.login))
    }

    private fun getUsers(forceRefresh: Boolean) {
        viewModelScope.launch(dispatchers.main) {
            _users.removeSource(userResource)
            withContext(dispatchers.io) {
                userResource = getTopUsersUseCase(cachingStrategy = NetworkBoundResource.LOAD_CACHE_ONLY)
            }
            _users.addSource(userResource) {
                _users.value = it
                if (it.status == Resource.Status.ERROR) _snackbarError.value =
                    Event(R.string.an_error_happened)
            }

        }
    }

}
