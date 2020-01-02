package com.zeng.repository.utils

import android.util.Log
import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import java.lang.Exception
import kotlin.coroutines.coroutineContext

abstract class NetworkBoundResource<ResultType, RequestType> {

    private val result = MutableLiveData<Resource<ResultType>>()
    private val supervisorJob = SupervisorJob()




    suspend fun build(): NetworkBoundResource<ResultType, RequestType> {
        withContext(Dispatchers.Main) {
            result.value =
                Resource.loading(null)
        }
        CoroutineScope(coroutineContext).launch(supervisorJob) {
            val dbResult = loadFromDb()
            when (cachingStrategy()) {
                LOAD_CACHE_ONLY -> {
                    //不使用网络，只读取本地缓存数据。
                    Log.d(NetworkBoundResource::class.java.name, "Return data from local database")
                    setValue(Resource.success(dbResult))
                }
                LOAD_NO_CACHE -> {
                    //不使用缓存，只从网络获取数据。
                    try {
                        fetchFromNetwork(dbResult)
                    } catch (e: Exception) {
                        Log.e("NetworkBoundResource", "An error happened: $e")
                        setValue(Resource.error(loadFromDb(), e))
                    }
                }
                LOAD_CACHE_ELSE_NETWORK -> {
                    //只要本地有，都使用缓存中的数据。本地没有缓存时才从网络上获取。
                    if (shouldFetch(dbResult)) {
                        try {
                            fetchFromNetwork(dbResult)
                        } catch (e: Exception) {
                            Log.e("NetworkBoundResource", "An error happened: $e")
                            setValue(Resource.error(loadFromDb(), e))
                        }
                    } else {
                        Log.d(
                            NetworkBoundResource::class.java.name,
                            "Return data from local database"
                        )
                        setValue(Resource.success(dbResult))
                    }
                }
                LOAD_CACHE -> {
                    //先使用缓存中的数据，再从网络上获取。
                    Log.d(NetworkBoundResource::class.java.name, "Return data from local database")
                    setValue(Resource.success(dbResult))

                    try {
                        fetchFromNetwork(dbResult)
                    } catch (e: Exception) {
                        Log.e("NetworkBoundResource", "An error happened: $e")
                        setValue(Resource.error(loadFromDb(), e))
                    }

                }
                else -> {
                    try {
                        fetchFromNetwork(dbResult)
                    } catch (e: Exception) {
                        Log.e("NetworkBoundResource", "An error happened: $e")
                        setValue(Resource.error(loadFromDb(), e))
                    }
                }

            }

        }
        return this
    }

    fun asLiveData() = result as LiveData<Resource<ResultType>>

    // ---

    private suspend fun fetchFromNetwork(dbResult: ResultType?) {
        Log.d(NetworkBoundResource::class.java.name, "Fetch data from network")
        setValue(Resource.loading(dbResult)) // Dispatch latest value quickly (UX purpose)
        val apiResponse = createCallAsync()
        Log.e(NetworkBoundResource::class.java.name, "Data fetched from network")
        saveCallResults(processResponse(apiResponse))
        setValue(Resource.success(loadFromDb()))
    }

    @MainThread
    protected fun setValue(newValue: Resource<ResultType>) {
        Log.d(NetworkBoundResource::class.java.name, "Resource: " + newValue)
        if (result.value != newValue) result.postValue(newValue)
    }

    @WorkerThread
    protected abstract fun processResponse(response: RequestType): ResultType

    @WorkerThread
    protected abstract suspend fun saveCallResults(items: ResultType)

    @MainThread
    protected abstract fun shouldFetch(data: ResultType?): Boolean

    @MainThread
    protected abstract fun cachingStrategy(): Int

    @MainThread
    protected abstract suspend fun loadFromDb(): ResultType?

    @MainThread
    protected abstract suspend fun createCallAsync(): RequestType

    companion object {

        const val LOAD_CACHE_ONLY = 1;//不使用网络，只读取本地缓存数据。
        const val LOAD_NO_CACHE = 2;//不使用缓存，只从网络获取数据。
        const val LOAD_CACHE_ELSE_NETWORK = 3;//只要本地有，都使用缓存中的数据。本地没有缓存时才从网络上获取。
        const val LOAD_CACHE = 4;//先使用缓存中的数据，再从网络上获取。
    }
}