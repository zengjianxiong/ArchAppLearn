package com.zeng.local.dao

import androidx.room.Dao
import com.zeng.model.Dog

@Dao
abstract class DogDao : BaseDao<Dog>()