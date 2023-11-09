package com.selva.movie.data.api

import okhttp3.Interceptor

const val API_KEY = "f7fff1e65e56cde9108b014001a69196"
const val BASE_URL = ""
const val POSTER_BASE_URL = ""

object TheMovieDB {
    fun getClient(): TheMovieDBInterface {
        val requestInterceptor = Interceptor { chain ->

            val url = chain.request()
                .url()
                .newBuilder()
                .addQueryParameter("app_key", API_KEY)
                .build()

            val request = chain.request()
                .newBuilder()
                .url(url)
                .build()

            return@Interceptor chain.proceed(request)
        }
    }
}