package com.android.androidtemplate.di

import android.content.Context
import com.android.androidtemplate.data.local.AppDataBase
import com.android.androidtemplate.data.local.UserDao
import com.android.androidtemplate.data.remote.repository.api.ApiService
import com.android.androidtemplate.data.remote.repository.ApiServiceRemoteDataSource
import com.android.androidtemplate.data.remote.repository.ApiServiceRemoteDataSourceImp
import com.android.androidtemplate.network.RetrofitBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun provideAPIRemoteDataSource(apiService: ApiService): ApiServiceRemoteDataSource {
        return ApiServiceRemoteDataSourceImp(apiService)
    }


    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext appContext: Context): AppDataBase {
        return AppDataBase.getDatabase(appContext)
    }

    @Provides
    @Singleton
    fun provideUserDAO(appDataBase: AppDataBase):UserDao{
        return appDataBase.userDao()
    }

}