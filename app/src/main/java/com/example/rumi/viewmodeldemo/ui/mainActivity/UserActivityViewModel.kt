package com.example.rumi.viewmodeldemo.mainActivity

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.example.rumi.viewmodeldemo.data.repository.UserRepository
import com.example.rumi.viewmodeldemo.domain.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by rumi on 5/29/18.
 */
class UserActivityViewModel @Inject constructor(private var userRepository: UserRepository) : ViewModel(), LifecycleObserver {

    private val compositeDisposable = CompositeDisposable()
    var userList = MutableLiveData<List<User>>()

    init {
        getUserList()
    }

    private fun getUserList() =
            compositeDisposable.add(userRepository.getUserList()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        userList.postValue(it)
                    }, {
                        println(it)
                    }))


    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun getLocalUserList(): LiveData<PagedList<User>> {
        val builder = PagedList.Config.Builder()
        val pagerListConfig: PagedList.Config = builder.setEnablePlaceholders(true).setPrefetchDistance(10).setPageSize(20).build()
        val userList = LivePagedListBuilder(userRepository.getLocalUserList(), pagerListConfig).build()
        return userList

    }
}