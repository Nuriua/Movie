package com.selva.movie.data.api

import okhttp3.Interceptor

const val API_KEY
object TheMovieDB {
    fun getClient(): TheMovieDBInterface{
        val requestInterceptor = Interceptor { chain ->
            val url = chain.request()
                .url()
                .newBuilder()
                .addQueryParameter("app_key", API_KEY)
                .build()

            val request = chain.request()
                .newBuilder()
                .url(url)
        }

}