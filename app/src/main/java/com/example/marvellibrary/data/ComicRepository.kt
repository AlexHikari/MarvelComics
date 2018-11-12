package com.example.marvellibrary.data

import com.example.marvellibrary.domain.Comic
import com.example.marvellibrary.framework.models.CharacterRawModel
import io.reactivex.Maybe
import io.reactivex.Single

class ComicRepository(private val marvelAPISource: ComicSource) {


    fun getCharacterByName(name: String): Maybe<CharacterRawModel> {

        return marvelAPISource.getCharacterByName(name)
    }

    fun getComicByCharacterId(characterId: Int): Single<List<Comic>> {
        return marvelAPISource.getComicByCharacterId(characterId)
    }
}

interface ComicSource {

    fun getCharacterByName(name: String): Maybe<CharacterRawModel>
    fun getComicByCharacterId(characterId: Int): Single<List<Comic>>
}