package com.android.androidtemplate.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.androidtemplate.data.model.User
import com.android.androidtemplate.data.repository.MainRepository
import com.android.androidtemplate.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


/**
 * @Author: Abdul Rehman
 * @Date: 20/04/2022.
 */

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {
    private val userList = MutableLiveData<Resource<List<User>>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        fetchUsers()
    }

    fun fetchUsers() {
        userList.postValue(Resource.loading(null))
        compositeDisposable.add(
            mainRepository.getContributors()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ usersList ->
                    userList.postValue(Resource.success(usersList))
                }, {
                    userList.postValue(Resource.error(null, it.message))
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getUsers(): LiveData<Resource<List<User>>> {
        return userList
    }
}