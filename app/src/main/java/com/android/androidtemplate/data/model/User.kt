package com.android.androidtemplate.data.model

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
    val id: Int?,
    @SerializedName("login")
    val name: String?,
    @SerializedName("url")
    val email: String?,
    @SerializedName("avatar_url")
    val avatar: String
)