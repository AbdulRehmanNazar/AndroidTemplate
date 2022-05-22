package com.android.androidtemplate.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.androidtemplate.data.model.User
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAllUsers(): LiveData<List<User>>

    @Query("SELECT * FROM user WHERE id = :id")
    fun getSingleUser(id: Int): LiveData<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllUsers(user: List<User>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSingleUser(user: User)


}