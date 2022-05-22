package com.android.androidtemplate.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.androidtemplate.data.local.AppDataBase
import com.android.androidtemplate.data.model.User
import com.android.androidtemplate.data.remote.repository.MainRepository
import com.android.androidtemplate.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


/**
 * @Author: Abdul Rehman
 * @Date: 20/04/2022.
 */

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository,
                                        private val dataBase: AppDataBase
) : ViewModel() {
    private val userList = MutableLiveData<Resource<List<User>>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        fetchUsers()
    }


    fun fetchUsers() {
        compositeDisposable.add(mainRepository.getContributors({
            compositeDisposable.add(mainRepository.addUserLocalDB(it))
        }, {
            Log.d("Abdul", "Error happen " + it.message.toString())
        }, {
            Log.d("Abdul", "Completed")
        }))
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getUsersLocalDB(): LiveData<List<User>> {
        return mainRepository.getListUsers()
    }

    fun getUsers(): LiveData<Resource<List<User>>> {
        return userList
    }
}