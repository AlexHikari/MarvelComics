package com.example.marvelcomics.api.models


class ComicResponse(val data: MarvelDataResponse)

class MarvelDataResponse(
    val character : CharacterResponse
)

class CharacterResponse(
    val id: Int,
    val name: String,
    val description: String
)



