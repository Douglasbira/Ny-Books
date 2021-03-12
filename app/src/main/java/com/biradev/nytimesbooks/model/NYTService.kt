package com.biradev.nytimesbooks.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface NYTService {
    @GET("lists.json")
    fun getBooks(
        @Query("api-key") apiKey: String = "8AH2kipmZwbL4mf2jVvCrXkAZHKLF0NT",
        @Query("list") list: String = "hardcover-fiction"
    ): Call<BookBodyResponse>
}