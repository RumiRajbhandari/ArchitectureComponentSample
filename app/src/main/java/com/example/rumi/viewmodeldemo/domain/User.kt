package com.example.rumi.viewmodeldemo.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by rumi on 5/30/18.
 */
data class User(
        @SerializedName("name") @Expose var name: String,
        @SerializedName("email") @Expose var email: String)