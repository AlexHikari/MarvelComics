package com.example.marvelcomics.domain

/**
 *
 * @property id Int
 * @property name String
 * @property description String
 * @property thumbnail ImageThumbnail
 * @constructor
 */
data class Character(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: ImageThumbnail
)

data class ImageThumbnail(
    val path: String,
    val extension: String
)

