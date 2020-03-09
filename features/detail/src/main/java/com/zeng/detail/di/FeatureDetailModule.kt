package com.zeng.detail.di

import com.zeng.detail.DetailFragment
import com.zeng.detail.DetailImageFragment
import com.zeng.detail.DetailImageViewModel
import com.zeng.detail.DetailViewModel
import com.zeng.detail.doman.GetUserDetailUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

val featureDetailModule = module {
    factory { GetUserDetailUseCase(get()) }

    viewModel { DetailViewModel(get(), get()) }
    viewModel { DetailImageViewModel() }
}