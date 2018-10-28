package com.example.marvelcomics.presentation

import android.view.View
import com.example.marvelcomics.domain.Character
import com.example.marvelcomics.domain.Comic
import com.example.marvelcomics.usecases.GetCharacter
import com.example.marvelcomics.usecases.GetComics

class mainPresenter(
    private var view: View?,
    private val getCharacter: GetCharacter,
    private val getComics: GetComics
    ){

    interface View{
        fun renderCharacter(character: Character)
        fun renderComics(comics: List<Comic>)
    }


}