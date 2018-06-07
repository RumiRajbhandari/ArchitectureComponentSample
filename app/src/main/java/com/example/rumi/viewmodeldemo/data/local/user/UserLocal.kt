package com.example.rumi.viewmodeldemo.data.local.user

import android.arch.paging.DataSource
import com.example.rumi.viewmodeldemo.domain.User

/**
 * Created by rumi on 5/30/18.
 */
interface UserLocal {
    fun getUserList(): DataSource.Factory<Int,User>
    fun insertAllUserList(userList:List<User>)

}