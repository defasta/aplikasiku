package com.defasta.aplikasiku.network

import com.defasta.aplikasiku.data.response.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    @GET(".")
    fun getMovies(
        @Query("apikey") apiKey: String,
        @Query("s") search: String
    ) : Call<MovieResponse>
}