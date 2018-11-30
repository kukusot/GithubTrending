package com.githubtrending.repos.domain.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class GithubRepository(
    val id: Long,
    val name: String,
    val fullName: String,
    val description: String,
    @SerializedName("stargazers_count") val stars: Int,
    val forksCount: Int,
    val updatedAt: Date,
    val language: String?,
    val license: Licence?,
    val htmlUrl: String
)