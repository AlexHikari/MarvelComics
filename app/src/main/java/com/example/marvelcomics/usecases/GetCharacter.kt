package com.example.marvelcomics.usecases

import com.example.marvelcomics.data.ComicRepository
import com.example.marvelcomics.domain.Character

class GetCharacter(private val comicRepository: ComicRepository){

    operator fun invoke(name: String): Character = comicRepository.getCharacterByName(name)
}