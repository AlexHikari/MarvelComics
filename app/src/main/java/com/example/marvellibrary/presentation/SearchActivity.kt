package com.example.marvellibrary.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.marvellibrary.R
import kotlinx.android.synthetic.main.item_toolbar.*

class SearchActivity : AppCompatActivity(), SearchPresenter.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        setSupportActionBar(findViewById(R.id.toolbar))
        searchView.setOnClickListener {
            imageView.setImageDrawable(null)
            Log.i("", "aaaaa")
        }
    }

}


