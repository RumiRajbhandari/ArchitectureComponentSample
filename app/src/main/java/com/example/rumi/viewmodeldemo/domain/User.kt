package com.example.rumi.viewmodeldemo.domain

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by rumi on 5/30/18.
 */
@Entity(tableName = "user")
data class User(
        @PrimaryKey @ColumnInfo(name = "name") @SerializedName("name") @Expose var name: String,
        @ColumnInfo(name="email") @SerializedName("email") @Expose var email: String)