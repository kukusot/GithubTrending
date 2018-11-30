package com.githubtrending.core

import kotlin.coroutines.CoroutineContext

data class AppCoroutineDispatcher(val main: CoroutineContext, val io: CoroutineContext)