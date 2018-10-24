package com.example.marvelcomics.api.service

import android.os.Build
import com.example.marvelcomics.BuildConfig
import retrofit2.http.GET

interface MarvelClient{

    @GET()
    fun getComics(name: String): ArrayList<ComicModel>
}