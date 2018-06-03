package com.example.rumi.viewmodeldemo.data.repository

import android.arch.lifecycle.LiveData
import com.example.rumi.viewmodeldemo.domain.User

/**
 * Created by rumi on 5/30/18.
 */
interface Repository {
    fun getUserList():LiveData<List<User>>
}