package com.android.androidtemplate.data.api

import com.android.androidtemplate.data.model.User
import com.android.androidtemplate.network.RetrofitBuilder
import io.reactivex.Single


/**
 * @Author: Abdul Rehman
 * @Date: 20/04/2022.
 */

class ApiServiceImpl : ApiService {
    override fun getContributors(): Single<List<User>> {
        return RetrofitBuilder.getRetrofit().create(ApiService::class.java).getContributors()
    }
}