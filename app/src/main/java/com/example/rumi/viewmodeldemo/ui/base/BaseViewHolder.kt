package com.example.rumi.viewmodeldemo.ui.base

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by rumi on 6/4/18.
 */
abstract class BaseViewHolder<in T>(itemView:View):RecyclerView.ViewHolder(itemView) {
    abstract fun bind(obj:T)
}