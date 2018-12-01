package com.githubtrending.repos.domain.data

import com.githubtrending.repos.domain.model.RepositoryResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val PAGE_SIZE = 50

interface RepositoriesService {

    @GET("search/repositories")
    fun getRepositories(
        @Query("q") query: String = "android",
        @Query("sort") sort: String = "stars",
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = PAGE_SIZE
    ): Deferred<Response<RepositoryResponse>>
}