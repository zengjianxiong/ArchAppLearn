package com.zeng.model

import androidx.room.Embedded
import androidx.room.Relation


data class DogAndOwner(
    @Embedded val owner: Owner,

    @Relation(parentColumn = "ownerId", entityColumn = "dogId")
    val dog: Dog
)