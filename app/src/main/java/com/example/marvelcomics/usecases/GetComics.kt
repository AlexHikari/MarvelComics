package com.example.marvelcomics.usecases

import com.example.marvelcomics.data.ComicRepository
import com.example.marvelcomics.domain.Comic

class GetComics(private val comicRepository: ComicRepository){

    operator fun invoke(characterId: Int): List<Comic> = comicRepository.getComicByCharacterId(characterId)
}