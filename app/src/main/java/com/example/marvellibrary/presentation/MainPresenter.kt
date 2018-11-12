package com.example.marvellibrary.presentation

import com.example.marvellibrary.domain.Character
import com.example.marvellibrary.domain.Comic
import com.example.marvellibrary.usecases.GetCharacter
import com.example.marvellibrary.usecases.GetComics

class MainPresenter(
    private var view: View,
    private val getCharacter: GetCharacter,
    private val getComics: GetComics
) {
    fun onButtonClicked(name: String) {

        getCharacter(
            name,
            onSuccess = { character: Character -> view.renderCharacter(character) },
            onError = { error: Throwable -> view.showCharacterError(error) },
            onEmpty = { view.showCharacterNotFound() }
        )
    }


    interface View {
        fun renderCharacter(character: Character)
        fun renderComics(comics: List<Comic>)
        fun showCharacterError(error: Throwable)
        fun showCharacterNotFound()
    }


}