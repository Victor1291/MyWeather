package com.shu.data.api

import okhttp3.Interceptor
import okhttp3.Response

internal class TimeApiKeyInterceptor(private val apikey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
        chain.request().newBuilder()
            .addHeader("X-Api-Key", apikey)
            .build()
        )
    }
}