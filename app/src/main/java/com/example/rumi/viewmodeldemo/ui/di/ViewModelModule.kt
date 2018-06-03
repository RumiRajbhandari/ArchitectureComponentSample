package com.example.rumi.viewmodeldemo.ui.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.rumi.viewmodeldemo.mainActivity.UserActivityViewModel
import com.example.rumi.viewmodeldemo.mainActivity.ViewModelFactory
import com.example.rumi.viewmodeldemo.mainActivity.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by rumi on 6/3/18.
 */
@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(UserActivityViewModel::class)
    internal abstract fun getMainActivityViewModel(viewModel: UserActivityViewModel): ViewModel

    //add other view model

}