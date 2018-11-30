package com.githubtrending.repos.domain.model

import com.google.gson.annotations.SerializedName

data class Licence(
    val key: String,
    val name: String,
    @SerializedName("spdx_id") val displayName: String
)