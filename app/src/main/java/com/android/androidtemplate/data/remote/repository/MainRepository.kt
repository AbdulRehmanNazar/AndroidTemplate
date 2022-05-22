package com.android.androidtemplate.data.remote.repository

import androidx.lifecycle.LiveData
import com.android.androidtemplate.data.local.AppDataBase
import com.android.androidtemplate.data.model.User
import io.reactivex.Completable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


/**
 * @Author: Abdul Rehman
 * @Date: 20/04/2022.
 */

class MainRepository @Inject constructor(private val apiServiceRemoteDataSource: ApiServiceRemoteDataSource,
                                         private val dataBase: AppDataBase
) {

    fun getContributors(success: (List<User>) -> Unit,
                        failure: (Throwable) -> Unit,
                        completed: () -> Unit
    ): Disposable {
        var disposable: Disposable? = null
        apiServiceRemoteDataSource.getContributors().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe(object : Observer<List<User>> {
                override fun onSubscribe(d: Disposable) {
                    disposable = d
                }

                override fun onNext(t: List<User>) {
                    success(t)
                }

                override fun onError(e: Throwable) {
                    failure(e)
                }

                override fun onComplete() {
                    completed()
                }

            })
        return disposable!!
    }


    fun addUserLocalDB(usersList: List<User>): Disposable {
        return Completable.fromAction {
            dataBase.userDao().insertAllUsers(usersList)
        }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe {
            println()
        }
    }


    fun getListUsers(): LiveData<List<User>> {
        return dataBase.userDao().getAllUsers()
    }


}