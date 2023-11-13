package com.selva.movie.data.api

import com.selva.movie.data.vobject.MovieDetails
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheMovieDBInterface {
    @GET("movie/popular")
    fun getPopularMovie(@Query("page")page: Int)
    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") id: Int): Single<MovieDetails>
}