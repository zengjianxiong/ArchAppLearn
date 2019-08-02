package com.zeng.local.di

import com.zeng.local.ArchAppDatabase
import com.zeng.local.dao.UserDao
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module


private const val DATABASE = "DATABASE"
val localModule = module {

    single(StringQualifier(DATABASE)) { ArchAppDatabase.buildDatabase(androidContext()) }
    factory { (get(StringQualifier(DATABASE)) as ArchAppDatabase).userDao() }


}