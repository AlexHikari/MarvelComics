package com.example.marvellibrary.domain

/**
 * Representation of the comic
 * @property id Int The unique ID of the comic resource.
 * @property digitalId Int The ID of the digital comic representation of this comic. Will be 0 if the comic is not available digitally.
 * @property title String The canonical title of the comic.
 * @property description String The preferred description of the comic.
 * @property format String The publication format of the comic e.g. comic, hardcover, trade paperback.
 * @property pageCount String The number of story pages in the comic.
 * @constructor
 */
data class Comic(
    val id: Int,
    val digitalId: Int,
    val title: String,
    val description: String,
    val format: String,
    val pageCount: String
)