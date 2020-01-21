package com.zeng.detail

import android.util.Log
import androidx.lifecycle.*
import com.zeng.common.base.BaseViewModel
import com.zeng.common.utils.Event
import com.zeng.detail.doman.GetUserDetailUseCase
import com.zeng.model.User
import com.zeng.repository.AppDispatchers
import com.zeng.repository.utils.Resource
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel(
    private val getUserDetailUseCase: GetUserDetailUseCase,
    private val dispatchers: AppDispatchers, lifecycleOwner: LifecycleOwner
) : BaseViewModel(lifecycleOwner) {

    private lateinit var argsLogin: String
    private var userSource: LiveData<Resource<User>> = MutableLiveData()

    private val _user = MediatorLiveData<User>()
    val user: LiveData<User> get() = _user
    private val _isLoading = MutableLiveData<Resource.Status>()
    val isLoading: LiveData<Resource.Status> get() = _isLoading

//    fun reloadDataWhenUserRefreshes() = getUserDetail(true)

//    fun loadDataWhenActivityStarts(login: String) {
//        argsLogin = login
//        getUserDetail(false)
//    }

    fun userClicksOnAvatarImage(user: User) {
        Log.d("T", user.toString())
        navigate(DetailFragmentDirections.actionDetailFragmentToImageDetailFragment(user.avatarUrl))
    }

//    private fun getUserDetail(forceRefresh: Boolean) = viewModelScope.launch(dispatchers.main) {
//        _user.removeSource(userSource)
//        withContext(dispatchers.io) {
//            userSource = getUserDetailUseCase(forceRefresh = forceRefresh, login = argsLogin)
//        }
//        _user.addSource(userSource) {
//            _user.value = it.data
//            _isLoading.value = it.status
//            if (it.status == Resource.Status.ERROR) _snackbarError.value = Event(R.string.an_error_happened)
//        }
//    }
}
