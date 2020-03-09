package com.zeng.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.zeng.model.DogAndOwner

@Dao
abstract class DogAndOwnerDao {

    @Query("select * from Owner")
    abstract suspend fun getDogsAndOwners(): List<DogAndOwner>
}