package com.android.androidtemplate.data.api

import com.android.androidtemplate.data.model.User
import io.reactivex.Single
import javax.inject.Inject


/**
 * @Author: Abdul Rehman
 * @Date: 20/04/2022.
 */

class ApiServiceRemoteDataSourceImp @Inject constructor(private val apiService: ApiService) :
    ApiServiceRemoteDataSource {
    override fun getContributors(): Single<List<User>> {
        return apiService.getContributors()
    }
}