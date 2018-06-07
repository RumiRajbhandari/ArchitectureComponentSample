package com.example.rumi.viewmodeldemo.domain

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.v7.util.DiffUtil
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull

/**
 * Created by rumi on 5/30/18.
 */
@Entity(tableName = "user")
data class User(
        @PrimaryKey @ColumnInfo(name = "name") @SerializedName("name") @Expose var name: String,
        @ColumnInfo(name = "email") @SerializedName("email") @Expose var email: String) {
    companion object {
        var DIFF_CALLBACK = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(@NotNull oldItem: User, @NotNull newItem: User): Boolean {
                return oldItem.name == newItem.name

            }

            override fun areContentsTheSame(@NotNull oldItem: User, @NotNull newItem: User?): Boolean {
                return oldItem == newItem
            }
        }
    }
}