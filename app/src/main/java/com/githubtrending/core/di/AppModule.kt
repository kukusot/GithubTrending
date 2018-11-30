package com.githubtrending.core.di

import com.githubtrending.core.AppCoroutineDispatcher
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers

@Module
object AppModule {

    @Provides
    @JvmStatic
    fun provideCoroutineDispatcher() = AppCoroutineDispatcher(
        main = Dispatchers.Main,
        io = Dispatchers.IO
    )

}