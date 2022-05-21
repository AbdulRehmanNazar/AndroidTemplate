package com.android.androidtemplate.data.remote.repository.api

import com.android.androidtemplate.data.model.User
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET


/**
 * @Author: Abdul Rehman
 * @Date: 20/04/2022.
 */

interface ApiService {

    @GET("contributors")
    fun getContributors(): Observable<List<User>>
//    suspend fun getContributors(): Single<List<User>>
}