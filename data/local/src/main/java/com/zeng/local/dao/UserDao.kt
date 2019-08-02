package com.zeng.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.zeng.model.User
import java.util.*

@Dao
abstract class UserDao : BaseDao<User>() {

    suspend fun save(user: User) {
        insert(user.apply { lastRefreshed = Date() })
    }

    suspend fun save(users: List<User>) {
        insert(users.apply { forEach { it.lastRefreshed = Date() } })
    }

    @Query("select * from User order by login asc limit 30")
    abstract fun getTopUsers(): List<User>

    @Query("select * from User where login = :login limit 1")
    abstract suspend fun getUser(login: String): User


}
