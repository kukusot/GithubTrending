package com.githubtrending.repos.ui

import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.githubtrending.repos.domain.data.PAGE_SIZE
import com.githubtrending.repos.domain.data.RepositoriesDataSourceFactory
import javax.inject.Inject

class ReposViewModel @Inject constructor(private val dataSourceFactory: RepositoriesDataSourceFactory) :
    ViewModel() {

    val repositoriesResult = LivePagedListBuilder(dataSourceFactory, pagedListConfig).build()
    val networkState = dataSourceFactory.repositoriesDataSource.networkState
    val repoCount = dataSourceFactory.repositoriesDataSource.repoCount

    override fun onCleared() {
        super.onCleared()
        dataSourceFactory.repositoriesDataSource.clear()
    }

    fun retry() {
        dataSourceFactory.repositoriesDataSource.retry()
    }

}

val pagedListConfig = PagedList.Config.Builder().apply {
    setEnablePlaceholders(false)
    setInitialLoadSizeHint(PAGE_SIZE)
    setPageSize(PAGE_SIZE)
}.build()