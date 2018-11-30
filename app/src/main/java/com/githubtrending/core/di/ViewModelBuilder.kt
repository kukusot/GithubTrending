package com.githubtrending.core.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelBuilder {

    @Binds
    abstract fun provideViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}