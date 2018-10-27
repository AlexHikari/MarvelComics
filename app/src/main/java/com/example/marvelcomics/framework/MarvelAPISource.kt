package com.example.marvelcomics.framework

import com.example.marvelcomics.data.ComicSource
import com.example.marvelcomics.domain.Character
import com.example.marvelcomics.domain.Comic
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MarvelAPISource : ComicSource{
    private val marvelAPI: MarvelAPI

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://gateway.marvel.com:443/v1/public/")
            //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        marvelAPI = retrofit.create(MarvelAPI::class.java)
    }

    override fun getCharacterByName(name: String): Character {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getComicByCharacterId(characterId: Int): List<Comic> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}