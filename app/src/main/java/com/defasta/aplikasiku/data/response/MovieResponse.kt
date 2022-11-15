package com.defasta.aplikasiku.data.response


import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("Response")
    val response: String,
    @SerializedName("Search")
    val search: List<Search>,
    val totalResults: String
)