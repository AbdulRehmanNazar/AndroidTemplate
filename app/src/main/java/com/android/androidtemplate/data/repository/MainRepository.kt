package com.android.androidtemplate.data.repository

import com.android.androidtemplate.data.api.ApiHelper
import com.android.androidtemplate.data.api.ApiServiceRemoteDataSource
import com.android.androidtemplate.data.api.ApiServiceRemoteDataSourceImp
import com.android.androidtemplate.data.model.User
import io.reactivex.Single
import javax.inject.Inject


/**
 * @Author: Abdul Rehman
 * @Date: 20/04/2022.
 */

class MainRepository @Inject constructor(private val apiServiceRemoteDataSource: ApiServiceRemoteDataSource) {
    fun getContributors(): Single<List<User>> {
        return apiServiceRemoteDataSource.getContributors()
    }
}