package com.zeng.remote.di

import com.zeng.remote.ApiService

import com.zeng.remote.UserDatasource
import okhttp3.Interceptor
import okhttp3.OkHttpClient
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
            level = HttpLoggingInterceptor.Level.HEADERS

        }
    }
    factory {
        OkHttpClient.Builder()
            .addInterceptor(interceptor = get())
            .build()
    }

    factory { get<Retrofit>().create(ApiService::class.java) }

    factory { UserDatasource(get()) }

}