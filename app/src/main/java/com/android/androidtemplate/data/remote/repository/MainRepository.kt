package com.android.androidtemplate.data.remote.repository

import com.android.androidtemplate.data.model.User
import io.reactivex.Observable
import javax.inject.Inject


/**
 * @Author: Abdul Rehman
 * @Date: 20/04/2022.
 */

class MainRepository @Inject constructor(private val apiServiceRemoteDataSource: ApiServiceRemoteDataSource) {
    fun getContributors(): Observable<List<User>> {
        return apiServiceRemoteDataSource.getContributors()
    }
}