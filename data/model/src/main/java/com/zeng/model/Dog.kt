package com.zeng.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Dog(
    @PrimaryKey val dogId: String,
    val ownerId: String
)