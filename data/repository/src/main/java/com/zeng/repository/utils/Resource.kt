package com.zeng.repository.utils

data class Resource<out T>(val status: Status, val data: T?, val throwable: Throwable?) {
    companion object {
        fun <T> success(data: T?) = Resource(Status.SUCCESS, data, null)

        fun <T> loading(data: T?) = Resource(Status.LOADING, data, null)

        fun <T> error(data: T?, error: Throwable) = Resource(Status.ERROR, data, error)
    }

    enum class Status {
        SUCCESS,
        LOADING,
        ERROR
    }
}

