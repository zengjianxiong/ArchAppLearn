package com.zeng.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import java.util.concurrent.TimeUnit


class DynamicTimeoutInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val questUrl: String = request.url.toString()
        val isCloseApi = false
//                = questUrl.contains(PayApi.API_CLOSEORDER)
        val isPollingApi = false
//                = questUrl.contains(PayApi.API_POLLING)

        return when {
            isCloseApi -> {
                chain.withConnectTimeout(30, TimeUnit.SECONDS)
                    .withReadTimeout(30, TimeUnit.SECONDS)
                    .proceed(request)
            }
            isPollingApi -> {
                chain.withReadTimeout(30, TimeUnit.SECONDS)
                    .proceed(request)
            }
            else -> chain.proceed(request)
        }
    }
}