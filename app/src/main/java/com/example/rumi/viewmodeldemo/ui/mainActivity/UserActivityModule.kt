package com.example.rumi.viewmodeldemo.mainActivity

import com.example.rumi.viewmodeldemo.data.remote.UserRemote
import com.example.rumi.viewmodeldemo.data.remote.UserRemoteImpl
import com.example.rumi.viewmodeldemo.data.repository.Repository
import com.example.rumi.viewmodeldemo.data.repository.RepositoryImpl
import com.example.rumi.viewmodeldemo.ui.di.qualifier.Remote
import dagger.Module
import dagger.Provides

/**
 * Created by rumi on 5/30/18.
 */
@Module
open class UserActivityModule {

    @Remote
    @Provides
    internal fun provideUserRemoteData(userRemoteImpl: UserRemoteImpl): UserRemote {
        return userRemoteImpl
    }

    @Provides
    internal fun provideUserRepository(repository: RepositoryImpl): Repository {
        return repository
    }


}