package com.zeng.home

import android.util.Log
import androidx.lifecycle.*
import com.trello.rxlifecycle3.android.lifecycle.kotlin.bindUntilEvent
import com.zeng.common.base.BaseFragment
import com.zeng.common.base.BaseViewModel
import com.zeng.common.utils.Event
import com.zeng.home.domain.GetTopUsersUseCase
import com.zeng.model.Banner
import com.zeng.model.User
import com.zeng.repository.AppDispatchers
import com.zeng.repository.utils.NetworkBoundResource
import com.zeng.repository.utils.Resource
import com.zeng.repository.utils.exception.ExceptionEngine
import io.reactivex.*
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.rx2.rxSingle
import kotlinx.coroutines.withContext
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import java.lang.Exception

class HomeViewModel(
    val getTopUsersUseCase: GetTopUsersUseCase,
    val dispatchers: AppDispatchers
) :
    BaseViewModel() {

    val TAG = HomeViewModel::class.java.name

    private val _users = MediatorLiveData<Resource<List<Banner.Item>>>()
    val users: LiveData<Resource<List<Banner.Item>>>
        get() = _users


    private var userResource: LiveData<Resource<List<Banner.Item>>> = MutableLiveData()

//    init {
//        getUsers(false)
//    }

    fun userRefreshesItems() = getUsers(true)

    fun userClicksOnItem(user: User) {

        Log.d("Tag", user.toString())
        navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(user.login))
    }


    private fun getUsers(forceRefresh: Boolean) {


//        val job = viewModelScope.launch(dispatchers.main) {
//            _users.removeSource(userResource)
//            rxSingle {
//                getTopUsersUseCase(cachingStrategy = NetworkBoundResource.LOAD_NO_CACHE)
//            }
//                .bindUntilEvent(lifecycleOwner, Lifecycle.Event.ON_DESTROY)
//                .observeOn(AndroidSchedulers.mainThread())
//                .onErrorReturn { throwable ->
//                    throwable.printStackTrace()
//                    return@onErrorReturn MutableLiveData(Resource.error(null, throwable))
//                }
//                .subscribe { liveData ->
//                    userResource = liveData
//                    addSource()
//                }
//        }

//        viewModelScope.launch(dispatchers.main) {
//            _users.removeSource(userResource)
//            withContext(dispatchers.io) {
//                userResource =
//                    getTopUsersUseCase(cachingStrategy = NetworkBoundResource.LOAD_CACHE_ONLY)
//
//
//            }
//            _users.addSource(userResource) {
//                _users.value = it
//                if (it.status == Resource.Status.ERROR) _snackbarError.value =
//                    Event(R.string.an_error_happened)
//            }
//
//        }

        viewModelScope.launch {

            flow {
                val case =
                    getTopUsersUseCase(cachingStrategy = NetworkBoundResource.LOAD_NO_CACHE)
                emit(case)
            }.flowOn(dispatchers.io)
                .catch {
                    it.printStackTrace()
                    emit(MutableLiveData(Resource.error(null, it)))
                }

                .collect { liveData ->
                    _users.addSource(liveData) {
                        _users.value = it
                        if (it.status == Resource.Status.ERROR) {
                            _snackbarError.value =
                                Event(ExceptionEngine.handleException(it.throwable).msg)
                            Log.d("error", ExceptionEngine.handleException(it.throwable).msg)
                        }
                    }
                }


        }


    }

    private fun addSource() {

        _users.addSource(userResource) {
            _users.value = it
            if (it.status == Resource.Status.ERROR) {
                _snackbarError.value =
                    Event(ExceptionEngine.handleException(it.throwable).msg)
                Log.d("error", ExceptionEngine.handleException(it.throwable).msg)
            }
        }
    }


}
