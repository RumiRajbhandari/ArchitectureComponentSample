package com.example.rumi.viewmodeldemo

import com.example.rumi.viewmodeldemo.ui.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by rumi on 5/30/18.
 */
class DemoApplication:DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()

    }
}