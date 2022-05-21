package com.android.androidtemplate.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.androidtemplate.data.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAllCharacters(): LiveData<List<User>>

    @Query("SELECT * FROM user WHERE id = :id")
    fun getCharacter(id: Int): LiveData<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(user: List<User>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)


}