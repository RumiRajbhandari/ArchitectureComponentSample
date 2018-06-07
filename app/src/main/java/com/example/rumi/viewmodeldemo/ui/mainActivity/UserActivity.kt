package com.example.rumi.viewmodeldemo.mainActivity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.rumi.viewmodeldemo.R
import com.example.rumi.viewmodeldemo.databinding.ActivityUserBinding
import com.example.rumi.viewmodeldemo.ui.base.BaseActivity
import com.example.rumi.viewmodeldemo.ui.mainActivity.UserAdapter
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class UserActivity : BaseActivity() {
    lateinit var binding:ActivityUserBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_user)


        var viewModel = ViewModelProviders.of(this, viewModelFactory)[UserActivityViewModel::class.java]
        viewModel.let {
            lifecycle.addObserver(it)
        }

        val linearLayoutManager=LinearLayoutManager(this)
        linearLayoutManager.orientation=LinearLayoutManager.VERTICAL
        binding.recyclerView.layoutManager=linearLayoutManager


        viewModel.getLocalUserList().observe(this, Observer {
            if (it!=null){
                val userAdapter=UserAdapter(this,it){
                    user, i ->
                    println("clicked user is $user")
                    return@UserAdapter user
                }
                binding.recyclerView.adapter=userAdapter
            }
        })

    }
}
