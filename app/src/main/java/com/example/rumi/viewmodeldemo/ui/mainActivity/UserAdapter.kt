package com.example.rumi.viewmodeldemo.ui.mainActivity

import android.content.Context
import android.databinding.ViewDataBinding
import com.example.rumi.viewmodeldemo.R
import com.example.rumi.viewmodeldemo.domain.User
import com.example.rumi.viewmodeldemo.ui.base.BaseAdapter
import com.example.rumi.viewmodeldemo.ui.base.BaseViewHolder

/**
 * Created by rumi on 6/4/18.
 */
class UserAdapter(private val mContext: Context,
                  private val userList: List<User>,
                  private val listener: (User, Int)->User) : BaseAdapter<BaseViewHolder<User>, User>(userList, User.DIFF_CALLBACK) {
    override val context: Context
        get() = mContext

    override fun onBindCustomViewHolder(holder: BaseViewHolder<User>, position: Int) {
        holder.bind(userList[position])
        holder.itemView.setOnClickListener{
            listener(userList[position],position)
        }
    }

    override fun getItemLayoutResource(viewType: Int): Int {
        return R.layout.user_single_row
    }

    override fun getViewHolder(binding: ViewDataBinding, viewType: Int): BaseViewHolder<User> {
        return UserViewHolder(binding)
    }
}