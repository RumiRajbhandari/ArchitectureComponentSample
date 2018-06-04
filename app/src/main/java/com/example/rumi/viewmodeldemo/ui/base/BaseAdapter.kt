package com.example.rumi.viewmodeldemo.ui.base

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by rumi on 6/4/18.
 */
abstract class BaseAdapter<T:RecyclerView.ViewHolder, S>(
        internal var list:List<S>
    ) :RecyclerView.Adapter<T>() {
    abstract val context:Context

     override fun onBindViewHolder(holder: T, position: Int) {
        onBindCustomViewHolder(holder,position)
    }

    protected abstract fun onBindCustomViewHolder(holder: T,position: Int)

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): T {
        var dataBinding=DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(context),getItemLayoutResource(viewType),parent,false)
        return getViewHolder(dataBinding,viewType)
    }

    protected abstract fun getItemLayoutResource(viewType: Int):Int
    abstract fun getViewHolder(binding: ViewDataBinding,viewType: Int):T


}