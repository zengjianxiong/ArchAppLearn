package com.zeng.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Banner(
    @SerializedName("list")
    val list: List<Item>
) {
    @Entity
    data class Item(
        @PrimaryKey
        @SerializedName("img_url")
        val imgUrl: String,
        @SerializedName("jump_type")
        val jumpType: Int,
        @SerializedName("jump_value")
        val jumpValue: String,
        @SerializedName("bg_color")
        val bgColor: String
    )
}