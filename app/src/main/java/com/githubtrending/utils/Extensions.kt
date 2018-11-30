package com.githubtrending.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.githubtrending.R
import com.google.android.material.snackbar.Snackbar
import java.text.DecimalFormat

fun Context.getLayoutInflater() = LayoutInflater.from(this)!!

fun ViewGroup.inflate(@LayoutRes resId: Int, attach: Boolean) =
    context.getLayoutInflater().inflate(resId, this, attach)!!

fun View.setVisibility(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.INVISIBLE
}

fun View.showRetrySnackBar(action: () -> Unit) {
    Snackbar.make(this, R.string.error_fetching_data, Snackbar.LENGTH_LONG).apply {
        setAction(R.string.try_again) {
            action()
        }
        show()
    }
}

fun Context.openUrlInWebView(url: String?) {
    try {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    } catch (e: Exception) {
        Log.e("ERROR", "Activity not found for $url")
    }
}

val thousandsFormatter = DecimalFormat("#,###")
fun Int.separateThousands() = thousandsFormatter.format(this)!!

val shortFormatter = DecimalFormat("#,###.#")
fun Int.shortDisplay(): String {
    return if (this < 1000) {
        toString()
    } else {
        val thousands = this * 1.0f / 1000
        shortFormatter.format(thousands) + "k"
    }
}