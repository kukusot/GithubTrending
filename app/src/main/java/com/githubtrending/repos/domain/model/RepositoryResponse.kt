package com.githubtrending.repos.domain.model

data class RepositoryResponse(val totalCount: Int, val items: List<GithubRepository>)