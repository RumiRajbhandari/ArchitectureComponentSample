package com.example.rumi.viewmodeldemo.data.local.user

import android.arch.paging.DataSource
import com.example.rumi.viewmodeldemo.data.local.DatabaseManager
import com.example.rumi.viewmodeldemo.domain.User
import javax.inject.Inject

/**
 * Created by rumi on 5/30/18.
 */
class UserLocalImpl @Inject constructor(private val databaseManager: DatabaseManager): UserLocal {

    override fun getUserList(): DataSource.Factory<Int,User> {
        return databaseManager.getUserDao().getAllUsers()

    }

    override fun insertAllUserList(userList: List<User>) {
        userList.forEach { it->databaseManager.getUserDao().insert(it) }
    }
}