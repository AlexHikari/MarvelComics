package com.example.marvelcomics.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import com.example.marvelcomics.R
import com.example.marvelcomics.data.ComicRepository
import com.example.marvelcomics.domain.Character
import com.example.marvelcomics.domain.Comic
import com.example.marvelcomics.framework.MarvelAPISource
import com.example.marvelcomics.usecases.GetCharacter
import com.example.marvelcomics.usecases.GetComics

class MainActivity : AppCompatActivity(), MainPresenter.View {


    private val apiSource = MarvelAPISource()
    private val repo = ComicRepository(apiSource)
    private val presenter: MainPresenter =
        MainPresenter(
            view = this@MainActivity,
            getCharacter = GetCharacter(repo),
            getComics = GetComics(repo)
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val searchButton: Button = findViewById(R.id.search_button)
        val characterText: TextView = findViewById(R.id.input_character)
        searchButton.setOnClickListener { presenter.onButtonClicked(characterText.text.toString()) }
    }

    override fun renderCharacter(character: Character) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun renderComics(comics: List<Comic>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showCharacterError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
