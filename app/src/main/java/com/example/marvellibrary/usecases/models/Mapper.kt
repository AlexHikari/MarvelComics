package com.example.marvellibrary.usecases.models

import com.example.marvellibrary.domain.Character
import com.example.marvellibrary.framework.models.CharacterRawModel

fun CharacterRawModel.convertToCharacter(): Character {
    return with(data.character[0]) {
        Character(
            id = id,
            name = name,
            description = description,
            imagePath = "${image.path}.${image.extension}"

        )
    }
}
