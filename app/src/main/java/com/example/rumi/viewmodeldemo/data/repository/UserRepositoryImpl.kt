package com.example.rumi.viewmodeldemo.data.repository

import com.example.rumi.viewmodeldemo.data.remote.user.UserRemote
import com.example.rumi.viewmodeldemo.domain.User
import com.example.rumi.viewmodeldemo.ui.di.qualifier.Remote
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by rumi on 5/30/18.
 */
class UserRepositoryImpl @Inject constructor(@Remote private val userRemote: UserRemote) : UserRepository {
    override fun getUserList(): Observable<List<User>> {
        return userRemote.getUserList()
    }
}