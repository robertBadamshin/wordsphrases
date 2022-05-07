package com.app.wordsphrases.translation_impl.data.datasource

import okhttp3.Interceptor
import okhttp3.Response

class OxfordHeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain.request()
                .newBuilder()
                .addHeader("app_key", "8c6f07ebe370921a2a37bb9bdf414848")
                .addHeader("app_id", "6bcf397e")
                .addHeader("Accept", "application/json")
                .build()
        )
    }
}