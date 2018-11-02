package com.example.marvelcomics.presentation

import com.example.marvelcomics.domain.Character
import com.example.marvelcomics.domain.Comic
import com.example.marvelcomics.usecases.GetCharacter
import com.example.marvelcomics.usecases.GetComics

class MainPresenter(
    private var view: View,
    private val getCharacter: GetCharacter,
    private val getComics: GetComics
) {
    fun onButtonClicked(name: String) {

        getCharacter(
            name,
            onSuccess = { character: Character -> view.renderCharacter(character) },
            onError = { error: Throwable -> view.showCharacterError(error) }
        )
    }


    interface View {
        fun renderCharacter(character: Character)
        fun renderComics(comics: List<Comic>)
        fun showCharacterError(error: Throwable)
    }


}