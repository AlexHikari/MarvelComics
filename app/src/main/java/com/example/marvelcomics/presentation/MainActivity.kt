package com.example.marvelcomics.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.marvelcomics.R
import com.example.marvelcomics.domain.Character
import com.example.marvelcomics.domain.Comic

class MainActivity : AppCompatActivity(), MainPresenter.View {

    //val presenter: MainPresenter = MainPresenter(view = this@MainActivity,getCharacter = GetCharacter())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // hello.setOnClickListener{presenter.onButtonClicked()}
    }

    override fun renderCharacter(character: Character) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun renderComics(comics: List<Comic>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
