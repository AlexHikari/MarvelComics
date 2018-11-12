package com.example.marvellibrary.presentation

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.marvellibrary.R
import com.example.marvellibrary.data.ComicRepository
import com.example.marvellibrary.domain.Character
import com.example.marvellibrary.domain.Comic
import com.example.marvellibrary.framework.MarvelAPISource
import com.example.marvellibrary.usecases.GetCharacter
import com.example.marvellibrary.usecases.GetComics

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
        val intent = Intent(this, SearchActivity::class.java.apply {

        })
        startActivity(intent)

    }

    override fun renderCharacter(character: Character) {


    }

    override fun renderComics(comics: List<Comic>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun showCharacterError(error: Throwable) {


    }

    override fun showCharacterNotFound() {
    }

}
