package com.githubtrending.repos.di

import com.githubtrending.repos.domain.data.RepositoriesService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ReposModule {

    @Provides
    fun provideRepositoriesService(retrofit: Retrofit): RepositoriesService =
        retrofit.create(RepositoriesService::class.java)

}