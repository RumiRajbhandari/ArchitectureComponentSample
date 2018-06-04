package com.example.rumi.viewmodeldemo.mainActivity

import com.example.rumi.viewmodeldemo.data.remote.user.UserRemote
import com.example.rumi.viewmodeldemo.data.remote.user.UserRemoteImpl
import com.example.rumi.viewmodeldemo.data.repository.UserRepository
import com.example.rumi.viewmodeldemo.data.repository.UserRepositoryImpl
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
    internal fun provideUserRepository(repository: UserRepositoryImpl): UserRepository {
        return repository
    }


}