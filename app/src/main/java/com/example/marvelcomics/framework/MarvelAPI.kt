package com.example.marvelcomics.framework

import com.example.marvelcomics.framework.models.CharacterRawModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelAPI {
    /**
     * GET
     * @param name ") name: String name of the character
     * @param apiKey String public api key to perform the call
     * @return Call<ComicResponse>
     */
    @GET("/v1/public/characters")
    fun getCharacter(@Query("ts") ts: String, @Query("name") name: String, @Query("apikey") apiKey: String, @Query("hash") hash: String): Single<CharacterRawModel>
}