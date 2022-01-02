package com.codingwithrufat.dihilt.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("discover/movie?")
    suspend fun getAllTVShows(
        @Query("api_key") api_key: String?
    ): Response<com.codingwithrufat.dihilt.models.Response>

}