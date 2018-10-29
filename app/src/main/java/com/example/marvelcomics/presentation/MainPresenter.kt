package com.example.marvelcomics.presentation

import com.example.marvelcomics.domain.Character
import com.example.marvelcomics.domain.Comic
import com.example.marvelcomics.usecases.GetCharacter
import com.example.marvelcomics.usecases.GetComics

class MainPresenter(
    private var view: View?,
    private val getCharacter: GetCharacter,
    private val getComics: GetComics
) {


    /*fun foo () {
        view.renderCharacter()
    }

    fun onButtonClicked() {
        view.renderCharacter()
    }*/

    interface View {
        fun renderCharacter(character: Character)
        fun renderComics(comics: List<Comic>)
    }


}