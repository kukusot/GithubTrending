package com.githubtrending.utils

import android.content.Context
import com.githubtrending.R
import java.util.*

private const val SECOND_MILLIS = 1000
private const val MINUTE_MILLIS = 60 * SECOND_MILLIS
private const val HOUR_MILLIS = 60 * MINUTE_MILLIS
private const val DAY_MILLIS = 24 * HOUR_MILLIS
fun Date.getTimeAgo(context: Context): String {
    if (time < 1000000000000L) {
        time *= 1000
    }

    val now = System.currentTimeMillis()
    if (time > now || time <= 0) {
        return ""
    }

    val diff = now - time
    return when {
        diff < MINUTE_MILLIS -> context.getString(R.string.just_now)
        diff < 2 * MINUTE_MILLIS -> context.getString(R.string.min_ago)
        diff < 50 * MINUTE_MILLIS -> {
            val mins = (diff / MINUTE_MILLIS)
            context.getString(R.string.mins_ago, mins)
        }
        diff < 90 * MINUTE_MILLIS -> context.getString(R.string.hours_ago)
        diff < 24 * HOUR_MILLIS -> {
            val hours = (diff / HOUR_MILLIS)
            context.getString(R.string.hours_ago, hours)
        }
        diff < 48 * HOUR_MILLIS -> context.getString(R.string.yesterday)
        else -> {
            val days = (diff / DAY_MILLIS)
            context.getString(R.string.days_ago, days)
        }
    }
}