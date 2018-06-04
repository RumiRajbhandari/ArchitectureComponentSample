package com.example.rumi.viewmodeldemo.data.remote

import com.example.rumi.viewmodeldemo.data.Constants
import com.example.rumi.viewmodeldemo.data.remote.user.RetrofitApiService
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by rumi on 6/4/18.
 */
@Module
open class ApiModule {
    @Singleton
    @Provides
    internal fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    internal fun getHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .addNetworkInterceptor(StethoInterceptor())
                .build()
    }

    @Provides
    @Singleton
    open fun remoteRepo(gson: Gson, client: OkHttpClient): RetrofitApiService {
        return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(client) //client is for logging the request and response
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(RetrofitApiService::class.java)
    }


}