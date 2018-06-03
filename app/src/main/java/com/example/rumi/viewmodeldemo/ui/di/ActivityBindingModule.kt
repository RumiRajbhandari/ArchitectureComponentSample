package com.example.rumi.viewmodeldemo.ui.di

import com.example.rumi.viewmodeldemo.mainActivity.UserActivity
import com.example.rumi.viewmodeldemo.mainActivity.UserActivityModule
import com.example.rumi.viewmodeldemo.ui.di.scopes.ActivityScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by rumi on 5/30/18.
 */
@Module
abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = [(UserActivityModule::class)])
    internal abstract fun mainActivity(): UserActivity

}