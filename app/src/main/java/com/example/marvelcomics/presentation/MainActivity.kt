package com.example.marvelcomics.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ListAdapter
import com.example.marvelcomics.R
import com.example.marvelcomics.data.ComicRepository
import com.example.marvelcomics.domain.Character
import com.example.marvelcomics.domain.Comic
import com.example.marvelcomics.framework.MarvelAPISource
import com.example.marvelcomics.usecases.GetCharacter
import com.example.marvelcomics.usecases.GetComics
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

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
        searchButton.setOnClickListener { presenter.onButtonClicked(textInputField.text.toString()) }
        characterScrollView.visibility = View.GONE

    }

    override fun renderCharacter(character: Character) {
        cleanView()
        characterScrollView.visibility = View.VISIBLE
        characterName.text = character.name
        characterDescription.text = character.description
        Picasso.get().load(character.imagePath)
            .into(characterImage)


    }

    override fun renderComics(comics: List<Comic>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private fun cleanView() {
        characterImage.setImageDrawable(null)
        characterName.text = ""
        characterDescription.text = ""
    }

    override fun showCharacterError(error: Throwable) {
        cleanView()
        characterScrollView.visibility = View.VISIBLE;
        characterName.text = error.message
    }

    override fun showCharacterNotFound() {
        cleanView()
        characterScrollView.visibility = View.VISIBLE;
        characterName.text = "No character Found with this name"
    }

}
