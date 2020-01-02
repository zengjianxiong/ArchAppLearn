package com.zeng.archapp.di

import com.zeng.detail.di.featureDetailModule
import com.zeng.home.di.featureHomeModule
import com.zeng.local.di.localModule
import com.zeng.remote.di.createRemoteModule
import com.zeng.repository.di.repositoryModule

val appCompontents = listOf(
    createRemoteModule("http://appapitest.indoorbuy.com/"), repositoryModule, localModule,
    featureHomeModule, featureDetailModule
)