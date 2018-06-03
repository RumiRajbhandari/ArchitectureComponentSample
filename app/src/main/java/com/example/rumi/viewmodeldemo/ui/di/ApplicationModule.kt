package com.example.rumi.viewmodeldemo.ui.di

import android.app.Application
import android.content.Context
import com.example.rumi.viewmodeldemo.mainActivity.UserActivityModule
import dagger.Binds
import dagger.Module

/**
 * Created by rumi on 5/30/18.
 */
@Module(includes = [(UserActivityModule::class)])
abstract class ApplicationModule {
    @Binds
internal abstract fun bindContext(application: Application): Context
}