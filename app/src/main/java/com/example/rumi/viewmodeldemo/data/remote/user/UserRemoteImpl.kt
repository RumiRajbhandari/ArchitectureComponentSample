package com.example.rumi.viewmodeldemo.data.remote.user

import com.example.rumi.viewmodeldemo.domain.User
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by rumi on 5/30/18.
 */
class UserRemoteImpl @Inject constructor(private val apiService: RetrofitApiService) : UserRemote {

    override fun getUserList(): Observable<List<User>> {
        return apiService.fetchUsers()

    }
}