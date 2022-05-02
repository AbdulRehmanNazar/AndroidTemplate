package com.android.androidtemplate.di

import com.android.androidtemplate.data.api.ApiService
import com.android.androidtemplate.data.api.ApiServiceRemoteDataSource
import com.android.androidtemplate.data.api.ApiServiceRemoteDataSourceImp
import com.android.androidtemplate.network.RetrofitBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


/**
 * @Author: Abdul Rehman
 * @Date: 30/04/2022.
 */

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    fun provideBaseURL(): String {
        return RetrofitBuilder.BASE_URL
    }

    @Provides
    fun provideOkhttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        return client;
    }

    @Provides
    fun provideRetrofit(baseURL: String, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create()).baseUrl(baseURL)
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideAPIService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideAPIRemoteDataSource(apiService: ApiService): ApiServiceRemoteDataSource{
        return ApiServiceRemoteDataSourceImp(apiService)
    }

}