package com.defasta.aplikasiku.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiServiceBuilder {
    private const val URL ="http://www.omdbapi.com/"
    //CREATE HTTP CLIENT
    private val okHttp = OkHttpClient.Builder()

    //retrofit builder
    private val builder = Retrofit.Builder().baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())

    //create retrofit Instance
    private val retrofit = builder.build()

    //we will use this class to create an anonymous inner class function that
    //implements Country service Interface

    fun <T> buildService (serviceType :Class<T>):T{
        return retrofit.create(serviceType)
    }
}