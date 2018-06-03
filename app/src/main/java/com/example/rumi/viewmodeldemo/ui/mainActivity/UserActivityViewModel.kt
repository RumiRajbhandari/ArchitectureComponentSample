package com.example.rumi.viewmodeldemo.mainActivity

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.rumi.viewmodeldemo.data.repository.Repository
import com.example.rumi.viewmodeldemo.domain.User
import javax.inject.Inject

/**
 * Created by rumi on 5/29/18.
 */
class UserActivityViewModel @Inject constructor(var repository: Repository) : ViewModel(), LifecycleObserver {

    fun getUserList(): LiveData<List<User>> {
        return repository.getUserList()
    }

}