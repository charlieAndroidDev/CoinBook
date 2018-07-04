package com.example.charlie.coinbook.di

import android.app.Application
import com.example.charlie.coinbook.CoinBookApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    ServiceModule::class,
    MainActivityModule::class,
    SchedulersModule::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application) : Builder

        fun build() : AppComponent
    }

    fun inject(coinBookApp: CoinBookApp)

}