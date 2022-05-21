package com.android.androidtemplate.data.remote.repository

import com.android.androidtemplate.data.model.User
import com.android.androidtemplate.data.remote.repository.api.ApiService
import io.reactivex.Observable
import javax.inject.Inject


/**
 * @Author: Abdul Rehman
 * @Date: 20/04/2022.
 */

class ApiServiceRemoteDataSourceImp @Inject constructor(private val apiService: ApiService) :
    ApiServiceRemoteDataSource {
    override fun getContributors(): Observable<List<User>> {
        return apiService.getContributors()
    }
}