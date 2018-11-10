package com.example.marvelcomics.usecases

import com.example.marvelcomics.data.ComicRepository

class GetComics(private val comicRepository: ComicRepository) {

    //operator fun invoke(characterId: Int): List<Comic> = comicRepository.getComicByCharacterId(characterId)
}