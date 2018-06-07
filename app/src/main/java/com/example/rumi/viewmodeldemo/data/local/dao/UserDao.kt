package com.example.rumi.viewmodeldemo.data.local.dao

import android.arch.lifecycle.LiveData
import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.rumi.viewmodeldemo.domain.User

/**
 * Created by rumi on 6/4/18.
 */
@Dao
interface UserDao {
    @Query("Select * from user")
    fun getAllUsers(): DataSource.Factory<Int, User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)
}