package com.example.rumi.viewmodeldemo.data.remote.user

import com.example.rumi.viewmodeldemo.domain.User
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by rumi on 6/4/18.
 */
interface RetrofitApiService {
    @GET("users")
    fun fetchUsers(): Observable<List<User>>
}