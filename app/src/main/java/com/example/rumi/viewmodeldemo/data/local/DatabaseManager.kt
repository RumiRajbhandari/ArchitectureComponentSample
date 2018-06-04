package com.example.rumi.viewmodeldemo.data.local

import android.content.Context
import com.example.rumi.viewmodeldemo.data.local.dao.UserDao
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by rumi on 6/4/18.
 */
@Singleton
class DatabaseManager @Inject constructor(context: Context){
    val instance =EvolveDatabase.getInstance(context)
    fun getUserDao():UserDao{
        return instance.userDao()
    }
}