package com.example.charlie.coinbook.di

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

@Module
class SchedulersModule {

    // Provide @Scheduler instance to make mocking easier
    @Singleton
    @Provides
    @Named("MAIN")
    fun mainScheduler() : Scheduler = AndroidSchedulers.mainThread()

    // Provide @Scheduler instance to make mocking easier
    @Singleton
    @Provides
    @Named("BACKGROUND")
    fun backgroundScheduler() : Scheduler = Schedulers.io()

}