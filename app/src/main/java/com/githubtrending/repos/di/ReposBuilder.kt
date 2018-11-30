package com.githubtrending.repos.di

import androidx.lifecycle.ViewModel
import com.githubtrending.core.di.ViewModelBuilder
import com.githubtrending.core.di.ViewModelKey
import com.githubtrending.repos.ui.ReposActivity
import com.githubtrending.repos.ui.ReposViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class ReposBuilder {

    @ContributesAndroidInjector(modules = [ReposModule::class, ViewModelBuilder::class])
    internal abstract fun contributeReposActivityInjector(): ReposActivity

    @Binds
    @IntoMap
    @ViewModelKey(ReposViewModel::class)
    internal abstract fun bindReposViewModel(viewModel: ReposViewModel): ViewModel
}