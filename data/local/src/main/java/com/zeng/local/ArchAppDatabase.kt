package com.zeng.local

import android.content.Context
import androidx.room.*
import com.zeng.local.converter.Converters
import com.zeng.local.dao.UserDao
import com.zeng.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ArchAppDatabase : RoomDatabase() {

    //dao
    abstract fun userDao(): UserDao

    companion object {
        fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, ArchAppDatabase::class.java, "ArchAppLearn.db")
                .build()
    }
}