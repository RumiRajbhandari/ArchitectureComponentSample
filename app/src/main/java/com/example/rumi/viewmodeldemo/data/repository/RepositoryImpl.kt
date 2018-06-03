package com.example.rumi.viewmodeldemo.data.repository

import android.arch.lifecycle.LiveData
import com.example.rumi.viewmodeldemo.data.remote.UserRemote
import com.example.rumi.viewmodeldemo.ui.di.qualifier.Remote
import com.example.rumi.viewmodeldemo.domain.User
import javax.inject.Inject

/**
 * Created by rumi on 5/30/18.
 */
class RepositoryImpl @Inject constructor(@Remote private val userRemote: UserRemote):Repository{
    override fun getUserList(): LiveData<List<User>> {
        return userRemote.getUserList()
    }
}