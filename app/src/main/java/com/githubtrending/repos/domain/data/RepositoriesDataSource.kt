package com.githubtrending.repos.domain.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.githubtrending.core.AppCoroutineDispatcher
import com.githubtrending.core.http.Result
import com.githubtrending.repos.domain.model.GithubRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.githubtrending.repos.domain.data.NetworkState.*
import javax.inject.Inject

class RepositoriesDataSource @Inject constructor(
    private val remoteDataSource: RepositoriesRemoteDataSource,
    private val appCoroutineDispatcher: AppCoroutineDispatcher
) : PageKeyedDataSource<Int, GithubRepository>() {


    val networkState: LiveData<NetworkState>
        get() = _networkState
    val repoCount: LiveData<Int>
        get() = _repoCount

    private val parentJob = Job()
    private val scope = CoroutineScope(appCoroutineDispatcher.io + parentJob)
    private val _networkState = MutableLiveData<NetworkState>()
    private val _repoCount = MutableLiveData<Int>()

    private var retryFun: (() -> Any)? = null

    fun retry() {
        val prevRetry = retryFun
        retryFun = null
        prevRetry?.invoke()
    }

    fun clear() {
        parentJob.cancel()
    }

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, GithubRepository>) {
        scope.launch {
            postNetworkState(LOADING)
            val result = remoteDataSource.fetchRepositories(0)

            if (result is Result.Success) {
                retryFun = null
                dispatchOnMainThread {
                    _networkState.value = SUCCESS
                    _repoCount.value = result.data.totalCount
                    callback.onResult(result.data.items, null, 1)
                }
            } else {
                retryFun = {
                    loadInitial(params, callback)
                }
                postNetworkState(ERROR)
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, GithubRepository>) {
        scope.launch {
            postNetworkState(LOADING)
            val response = remoteDataSource.fetchRepositories(params.key)

            if (response is Result.Success) {
                retryFun = null
                dispatchOnMainThread {
                    _networkState.value = SUCCESS
                    callback.onResult(response.data.items, params.key + 1)
                }
            } else {
                retryFun = {
                    loadAfter(params, callback)
                }
                postNetworkState(ERROR)
            }
        }
    }

    private suspend fun postNetworkState(state: NetworkState) = dispatchOnMainThread {
        _networkState.value = state
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, GithubRepository>) {
    }

    private suspend fun dispatchOnMainThread(block: () -> Unit) {
        withContext(appCoroutineDispatcher.main) {
            block()
        }
    }

}