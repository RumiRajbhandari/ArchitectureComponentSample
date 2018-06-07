package com.example.rumi.viewmodeldemo.data.remote.user

import com.example.rumi.viewmodeldemo.domain.User
import io.reactivex.Observable

/**
 * Created by rumi on 5/30/18.
 */
interface UserRemote {
    fun getUserList(): Observable<List<User>>

}
