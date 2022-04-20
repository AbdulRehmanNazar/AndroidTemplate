package com.android.androidtemplate.data.model

import com.google.gson.annotations.SerializedName


/**
 * @Author: Abdul Rehman
 * @Date: 20/04/2022.
 */
data class User(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("login")
    val name: String?,
    @SerializedName("url")
    val email: String?,
    @SerializedName("avatar_url")
    val avatar: String
)