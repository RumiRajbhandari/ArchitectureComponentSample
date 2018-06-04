package com.example.rumi.viewmodeldemo.ui.mainActivity

import android.databinding.ViewDataBinding
import com.example.rumi.viewmodeldemo.BR
import com.example.rumi.viewmodeldemo.domain.User
import com.example.rumi.viewmodeldemo.ui.base.BaseViewHolder

/**
 * Created by rumi on 6/4/18.
 */
class UserViewHolder(private val itemDataBinding: ViewDataBinding) : BaseViewHolder<User>(itemDataBinding.root) {
    override fun bind(obj: User) {
        itemDataBinding.setVariable(BR.user, obj)
        itemDataBinding.executePendingBindings()
    }
}