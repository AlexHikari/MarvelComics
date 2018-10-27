package com.example.marvelcomics.data

import com.example.marvelcomics.domain.Character
import com.example.marvelcomics.domain.Comic

class ComicRepository(private val marvelAPISource: ComicSource){



    fun getCharacterByName(name: String): Character {
        return marvelAPISource.getCharacterByName(name)
    }

    fun getComicByCharacterId(characterId: Int): List<Comic>{
        return marvelAPISource.getComicByCharacterId(characterId)
    }
}

interface ComicSource{

    fun getCharacterByName(name: String): Character
    fun getComicByCharacterId(characterId: Int): List<Comic>
}