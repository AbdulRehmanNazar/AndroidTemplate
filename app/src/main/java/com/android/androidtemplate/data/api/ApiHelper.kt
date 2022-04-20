package com.android.androidtemplate.data.api


/**
 * @Author: Abdul Rehman
 * @Date: 20/04/2022.
 */

class ApiHelper(private val apiService: ApiService) {
     fun getContributors() = apiService.getContributors()
}