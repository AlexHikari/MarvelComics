package com.example.marvelcomics.data

import com.example.marvelcomics.domain.Comic
import com.example.marvelcomics.framework.models.CharacterRawModel
import io.reactivex.Single

class ComicRepository(private val marvelAPISource: ComicSource) {


    fun getCharacterByName(name: String): Single<CharacterRawModel> {
        return marvelAPISource.getCharacterByName(name)
    }

    fun getComicByCharacterId(characterId: Int): Single<List<Comic>> {
        return marvelAPISource.getComicByCharacterId(characterId)
    }
}

interface ComicSource {

    fun getCharacterByName(name: String): Single<CharacterRawModel>
    fun getComicByCharacterId(characterId: Int): Single<List<Comic>>
}