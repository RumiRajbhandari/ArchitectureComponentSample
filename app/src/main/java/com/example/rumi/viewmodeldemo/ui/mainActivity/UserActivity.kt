package com.example.rumi.viewmodeldemo.mainActivity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.example.rumi.viewmodeldemo.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class UserActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var viewModel=ViewModelProviders.of(this,viewModelFactory)[UserActivityViewModel::class.java]
        viewModel.let {
            lifecycle.addObserver(it)
        }
        viewModel.getUserList().observe(this, Observer { text_user.text=it.toString() })


    }
}
