package com.zeng.local

import android.content.Context
import androidx.room.*
import com.zeng.local.converter.Converters
import com.zeng.local.dao.*
import com.zeng.model.Banner
import com.zeng.model.Dog
import com.zeng.model.Owner
import com.zeng.model.User

@Database(entities = [User::class, Banner.Item::class, Dog::class, Owner::class], version = 2)
@TypeConverters(Converters::class)
abstract class ArchAppDatabase : RoomDatabase() {

    //dao
    abstract fun userDao(): UserDao
    abstract fun bannerDao(): BannerDao
    abstract fun dogDao(): DogDao
    abstract fun ownerDao(): OwnerDao
    abstract fun dogAndOwnerDao(): DogAndOwnerDao

    companion object {
        fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, ArchAppDatabase::class.java, "ArchAppLearn.db")
                .fallbackToDestructiveMigration()
                .build()
    }
}