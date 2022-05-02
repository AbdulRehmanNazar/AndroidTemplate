package com.android.androidtemplate.data.api

import javax.inject.Inject


/**
 * @Author: Abdul Rehman
 * @Date: 20/04/2022.
 */

class ApiHelper @Inject constructor(private val apiService: ApiServiceRemoteDataSource) {
     fun getContributors() = apiService.getContributors()
}