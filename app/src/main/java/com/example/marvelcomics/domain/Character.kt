package com.example.marvelcomics.domain

/**
 *
 * @property id Int The unique ID of the character resource.
 * @property name String The name of the character.
 * @property description String A short bio or description of the character.
 * @constructor
 */
data class Character(
    val id: Int,
    val name: String,
    val description: String
)



