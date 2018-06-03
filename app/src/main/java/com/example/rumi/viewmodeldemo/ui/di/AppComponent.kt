package com.example.rumi.viewmodeldemo.ui.di

import android.app.Application
import com.example.rumi.viewmodeldemo.DemoApplication
import com.example.rumi.viewmodeldemo.mainActivity.UserActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by rumi on 5/30/18.
 */
@Singleton
@Component(modules = [
    (AndroidSupportInjectionModule::class),
    (ApplicationModule::class),
    (ViewModelModule::class),
    (ActivityBindingModule::class)

    ])
    interface AppComponent : AndroidInjector<DemoApplication> {
        @Component.Builder
        interface Builder {
            @BindsInstance
            fun application(application: Application): AppComponent.Builder

            fun build(): AppComponent
        }
}