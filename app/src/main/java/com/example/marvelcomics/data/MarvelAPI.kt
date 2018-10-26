package com.example.marvelcomics.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelAPI{
    /**
     * GET
     * @param name ") name: String name of the character
     * @param apiKey String public api key to perform the call
     * @return Call<ComicResponse>
     */
    @GET("/characters")
    fun getCharacter(@Query("name") name: String, @Query("apikey") apiKey: String): Call<ComicResponse>
}