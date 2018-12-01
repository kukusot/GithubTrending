package com.githubtrending.core.di

import android.content.Context
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import com.githubtrending.R

@GlideModule
class GlideModule : AppGlideModule() {

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        val memoryCache = 1024 * 1024 * 10L

        builder.apply {
            setMemoryCache(LruResourceCache(memoryCache))
            setDefaultRequestOptions(createRequestOptions())
        }
    }

    private fun createRequestOptions(): RequestOptions {
        return RequestOptions().apply {
            placeholder(R.drawable.ic_placeholder)
            error(R.drawable.ic_placeholder)
            skipMemoryCache(false)
        }
    }

}