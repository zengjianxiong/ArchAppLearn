package com.zeng.home.di

import com.zeng.home.HomeFragment
import com.zeng.home.HomeViewModel
import com.zeng.home.domain.GetTopUsersUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module


val featureHomeModule = module {
    factory { GetTopUsersUseCase(get())}
    factory(StringQualifier(value = "HOMEFRAGMENT")) { HomeFragment() }
    viewModel { HomeViewModel(get(), get(),get(StringQualifier(value = "HOMEFRAGMENT"))) }
}