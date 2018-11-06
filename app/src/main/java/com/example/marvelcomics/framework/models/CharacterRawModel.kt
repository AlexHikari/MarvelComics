package com.example.marvelcomics.framework.models

import com.squareup.moshi.Json


data class CharacterRawModel(
    @field:Json(name = "data") val data: CModel
)

data class CModel(
    @field:Json(name = "results") val character: List<CharacterModel> = listOf()
)

data class CharacterModel(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "description") val description: String,
    @field:Json(name = "thumbnail") val image: ImageModel
)

data class ImageModel(
    @field:Json(name = "path") val path: String,
    @field:Json(name = "extension") val extension: String
)