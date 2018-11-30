package com.githubtrending.core.http

import android.util.Log

inline fun <T : Any> safeApiCall(call: () -> Result<T>): Result<T> {
    return try {
        call()
    } catch (e: Throwable) {
        Log.e("API ERROR", "Exception ${e.localizedMessage}")
        Result.Error(e)
    }
}