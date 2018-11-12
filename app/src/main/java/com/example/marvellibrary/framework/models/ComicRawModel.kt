package com.example.marvellibrary.framework.models

import com.squareup.moshi.Json


data class ComicRawModel(
    @field:Json(name = "resourceURI") val pathToComicData: String,
    @field:Json(name = "name") val comicName: String
)