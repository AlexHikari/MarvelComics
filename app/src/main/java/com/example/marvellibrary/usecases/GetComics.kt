package com.example.marvellibrary.usecases

import com.example.marvellibrary.data.ComicRepository

class GetComics(private val comicRepository: ComicRepository) {

    //operator fun invoke(characterId: Int): List<Comic> = comicRepository.getComicByCharacterId(characterId)
}