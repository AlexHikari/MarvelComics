package com.example.marvellibrary.presentation

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.provider.SearchRecentSuggestions
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.SearchView
import com.example.marvellibrary.R
import com.example.marvellibrary.presentation.providers.MySuggestionProvider
import kotlinx.android.synthetic.main.activity_search.*

class Search : AppCompatActivity(), SearchPresenter.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        if (Intent.ACTION_SEARCH == intent.action) {
            intent.getStringExtra(SearchManager.QUERY)?.also { query ->
                SearchRecentSuggestions(
                    this,
                    MySuggestionProvider.AUTHORITY,
                    MySuggestionProvider.MODE
                ).saveRecentQuery(query, null)
            }
        }
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.i("busqueda", query)
                return true
            }

        })
    }
}


