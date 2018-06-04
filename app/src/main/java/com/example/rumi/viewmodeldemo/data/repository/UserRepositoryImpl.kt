package com.example.rumi.viewmodeldemo.data.repository

import android.arch.lifecycle.LiveData
import com.example.rumi.viewmodeldemo.data.local.user.UserLocal
import com.example.rumi.viewmodeldemo.data.remote.user.UserRemote
import com.example.rumi.viewmodeldemo.domain.User
import com.example.rumi.viewmodeldemo.ui.di.qualifier.Local
import com.example.rumi.viewmodeldemo.ui.di.qualifier.Remote
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by rumi on 5/30/18.
 */
class UserRepositoryImpl @Inject constructor(@Remote private val userRemote: UserRemote,
                                             @Local private val userLocal: UserLocal) : UserRepository {
    override fun getUserList(): Observable<List<User>> {
        return userRemote.getUserList()
                .doOnNext{userLocal.insertAllUserList(it)}
    }

    override fun getLocalUserList(): LiveData<List<User>> {
        return userLocal.getUserList()
    }
}