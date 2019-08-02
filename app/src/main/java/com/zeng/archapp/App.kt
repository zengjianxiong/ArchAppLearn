package com.zeng.archapp

import android.app.Application
import com.zeng.archapp.di.appCompontents
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

open class App : Application() {
    override fun onCreate() {
        super.onCreate()
        configureDi();
    }

    open fun configureDi() = startKoin {
        androidLogger()
        androidContext(this@App)
        modules(provideComponent())
    }


    open fun provideComponent() = appCompontents

}