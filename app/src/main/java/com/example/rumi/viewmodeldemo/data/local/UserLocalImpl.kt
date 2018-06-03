package com.example.rumi.viewmodeldemo.data.local

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.rumi.viewmodeldemo.domain.User
import javax.inject.Inject

/**
 * Created by rumi on 5/30/18.
 */
class UserLocalImpl @Inject constructor():UserLocal {
    override fun getUserList(): LiveData<List<User>> {
        var userList= mutableListOf<User>()
        var userList2= MutableLiveData<List<User>>()
        userList.add(User("ram","ktm"))
        userList.add(User("shyam","ktm"))
        userList.add(User("hari","ktm"))
        userList.add(User("gita","ktm"))
        userList2.value=userList
        return userList2

    }
}