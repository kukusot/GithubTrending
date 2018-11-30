package com.githubtrending.repos.domain.data

import androidx.paging.DataSource
import com.githubtrending.repos.domain.model.GithubRepository
import javax.inject.Inject

class RepositoriesDataSourceFactory @Inject constructor(val repositoriesDataSource: RepositoriesDataSource) :
    DataSource.Factory<Int, GithubRepository>() {

    override fun create(): DataSource<Int, GithubRepository> = repositoriesDataSource
}