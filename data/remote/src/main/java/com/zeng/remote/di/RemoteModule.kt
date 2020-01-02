package com.zeng.remote.di

import com.zeng.remote.ApiService

import com.zeng.remote.UserDatasource
import com.zeng.remote.interceptor.DynamicTimeoutInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


fun createRemoteModule(baseUrl: String) = module {

    single {
        Retrofit.Builder()
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }
    factory<Interceptor> {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY

        }
    }
    factory {
        OkHttpClient.Builder()
            .addInterceptor(interceptor = get())
            .addInterceptor(interceptor = object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): Response {
                    val request = chain.request()
                    val builder = request.url.newBuilder()
                    builder.addQueryParameter("mac", "ffffffffb3f2378cffffffffef05ac4a")
                    builder.addQueryParameter("version_code", "3.2.94")
                    builder.addQueryParameter("client", "android")
                    builder.addQueryParameter("version", 3294.toString())
                    builder.addQueryParameter(
                        "token",
                        "8ZDzCc%252FQt5fUSkqUCLrl83Qghe6mWvL%252B9DRhsko9pEM%253D"
                    )
                    return chain.proceed(request = request.newBuilder().url(builder.build()).build())
                }
            })
            .addInterceptor(interceptor = DynamicTimeoutInterceptor())
            .build()
    }

    factory { get<Retrofit>().create(ApiService::class.java) }

    factory { UserDatasource(get()) }

}