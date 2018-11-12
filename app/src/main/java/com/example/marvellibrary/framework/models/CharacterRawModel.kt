package com.example.marvellibrary.framework.models

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
    @field:Json(name = "thumbnail") val image: ImageModel,
    @field:Json(name = "comics") val comicList: ComicListRawModel
)

data class ImageModel(
    @field:Json(name = "path") val path: String,
    @field:Json(name = "extension") val extension: String
)

data class ComicListRawModel(
    @field:Json(name = "available") val NumberOfComics: Int,
    @field:Json(name = "collectionURI") val pathToComicCollection: String,
    @field:Json(name = "items") val Items: List<ComicRawModel> = listOf()
)