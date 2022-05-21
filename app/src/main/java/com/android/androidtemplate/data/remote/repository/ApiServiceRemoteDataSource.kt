package com.android.androidtemplate.data.remote.repository

import com.android.androidtemplate.data.model.User
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET


/**
 * @Author: Abdul Rehman
 * @Date: 20/04/2022.
 */

interface ApiServiceRemoteDataSource {
    fun getContributors(): Observable<List<User>>
}