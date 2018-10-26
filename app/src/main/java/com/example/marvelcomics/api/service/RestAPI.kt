package com.example.marvelcomics.api.service

import com.example.marvelcomics.BuildConfig
import com.example.marvelcomics.api.models.ComicResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class RestAPI {
    private val marvelAPI: MarvelAPI

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://gateway.marvel.com:443/v1/public/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        marvelAPI = retrofit.create(MarvelAPI::class.java)
    }

    /**
     * Get character info from the Marvel API
     * @param name String name of the character
     * @return Call<ComicResponse>
     */
    fun getCharacter(name: String): Call<ComicResponse>{
        return marvelAPI.getCharacter(name,BuildConfig.marvelPublicApiKey)
    }
}
