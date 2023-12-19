package com.android.androidtemplate.data.remote.repository

import com.android.androidtemplate.data.model.User
import io.reactivex.Observable


/**
 * @Author: Abdul Rehman
 * @Date: 20/04/2022.
 */

interface ApiServiceRemoteDataSource {
    fun getContributors(): Observable<List<User>>
}