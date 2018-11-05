package com.example.marvelcomics.domain


data class Character(
    val data: CharacterRawModel?
)

data class CharacterRawModel(
    val offset: Int?,
    val limit: Int?,
    val total: Int?,
    val count: Int?,
    val results: List<CharacterModel>
)

data class CharacterModel(

    val data: Any

)