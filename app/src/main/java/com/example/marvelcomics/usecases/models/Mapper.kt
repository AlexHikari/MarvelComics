package com.example.marvelcomics.usecases.models

import com.example.marvelcomics.domain.Character
import com.example.marvelcomics.framework.models.CharacterRawModel

fun CharacterRawModel.convertToCharacter(): Character {
    return with(data.character[0]) {
        Character(
            id = id,
            name = name,
            description = description,
            imagePath = "${image.path}${image.extension}"

        )
    }
}
