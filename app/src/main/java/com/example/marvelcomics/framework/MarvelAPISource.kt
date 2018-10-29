package com.example.marvelcomics.framework

import com.example.marvelcomics.BuildConfig
import com.example.marvelcomics.data.ComicSource
import com.example.marvelcomics.domain.Character
import com.example.marvelcomics.domain.Comic
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class MarvelAPISource : ComicSource{
    private val marvelAPI: MarvelAPI

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://gateway.marvel.com:443/v1/public/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        marvelAPI = retrofit.create(MarvelAPI::class.java)
    }

    override fun getCharacterByName(name: String): Single<Character> {
        return marvelAPI.getCharacter(name,BuildConfig.marvelPublicApiKey)
    }

    override fun getComicByCharacterId(characterId: Int): Single<List<Comic>> {
        TODO("GET not implemented yet")
    }

}