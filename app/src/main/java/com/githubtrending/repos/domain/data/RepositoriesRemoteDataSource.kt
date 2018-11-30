package com.githubtrending.repos.domain.data

import com.githubtrending.core.http.Result
import com.githubtrending.core.http.safeApiCall
import java.io.IOException
import javax.inject.Inject

class RepositoriesRemoteDataSource @Inject constructor(private val service: RepositoriesService) {

    suspend fun fetchRepositories(page: Int) = safeApiCall {
        val response = service.getRepositories(page = page).await()
        if (response.isSuccessful && response.body() != null) {
            Result.Success(response.body()!!)
        } else {
            Result.Error(IOException(response.message()))
        }
    }
}