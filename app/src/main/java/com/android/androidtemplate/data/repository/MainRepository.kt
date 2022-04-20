package com.android.androidtemplate.data.repository

import com.android.androidtemplate.data.api.ApiHelper
import com.android.androidtemplate.data.model.User
import io.reactivex.Single


/**
 * @Author: Abdul Rehman
 * @Date: 20/04/2022.
 */

class MainRepository (private val apiHelper: ApiHelper){
    fun getContributors(): Single<List<User>> {
        return apiHelper.getContributors()
    }
}