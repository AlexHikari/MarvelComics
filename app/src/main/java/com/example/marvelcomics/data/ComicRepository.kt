package com.example.marvelcomics.data

import com.example.marvelcomics.domain.Character
import com.example.marvelcomics.domain.Comic
import io.reactivex.Single

class ComicRepository(private val marvelAPISource: ComicSource) {


    fun getCharacterByName(name: String): Single<Character> {
        return marvelAPISource.getCharacterByName(name)
    }

    fun getComicByCharacterId(characterId: Int): Single<List<Comic>> {
        return marvelAPISource.getComicByCharacterId(characterId)
    }
}

interface ComicSource {

    fun getCharacterByName(name: String): Single<Character>
    fun getComicByCharacterId(characterId: Int): Single<List<Comic>>
}