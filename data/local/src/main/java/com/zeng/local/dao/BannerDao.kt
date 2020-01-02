package com.zeng.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.zeng.model.Banner
import com.zeng.model.User
import java.util.*

@Dao
abstract class BannerDao : BaseDao<Banner.Item>() {
    suspend fun save(user: Banner.Item) {
        insert(user)
    }

    suspend fun save(users: List<Banner.Item>) {
        insert(users)
    }

    @Query("select * from Item")
    abstract fun getBanners(): List<Banner.Item>

}