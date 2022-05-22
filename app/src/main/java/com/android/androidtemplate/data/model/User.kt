package com.android.androidtemplate.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


/**
 * @Author: Abdul Rehman
 * @Date: 20/04/2022.
 */

@Entity(tableName = "user")
data class User(
    @PrimaryKey
    @SerializedName("id")
    @ColumnInfo(name ="id")
    val id: Int?,
    @SerializedName("login")
    @ColumnInfo(name ="name")
    val name: String?,
    @SerializedName("url")
    @ColumnInfo(name ="email")
    val email: String?,
    @ColumnInfo(name ="profilephoto")
    @SerializedName("avatar_url")
    val avatar: String
)