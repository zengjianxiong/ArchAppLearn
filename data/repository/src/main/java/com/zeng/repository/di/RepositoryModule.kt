package com.zeng.repository.di

import com.zeng.repository.AppDispatchers
import com.zeng.repository.UsersRepository
import com.zeng.repository.UsersRepositoryImpl
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module


val repositoryModule = module {
    factory { AppDispatchers(Dispatchers.Main, Dispatchers.IO) }
    factory { UsersRepositoryImpl(get(), get()) as UsersRepository }
}