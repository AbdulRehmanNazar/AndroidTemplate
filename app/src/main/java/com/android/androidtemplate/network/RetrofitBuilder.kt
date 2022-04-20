package com.android.androidtemplate.network

import com.android.androidtemplate.data.api.ApiService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


/**
 * @Author: Abdul Rehman
 * @Date: 20/04/2022.
 */
object RetrofitBuilder {
    private const val BASE_URL = "https://api.github.com/repos/ruby/ruby/"

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL)
            .build()
    }
}