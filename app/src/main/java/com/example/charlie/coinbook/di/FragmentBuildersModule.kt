package com.example.charlie.coinbook.di

import com.example.charlie.coinbook.ui.DashboardFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeDashboardFragment() : DashboardFragment

}