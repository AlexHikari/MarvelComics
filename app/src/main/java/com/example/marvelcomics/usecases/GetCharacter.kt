package com.example.marvelcomics.usecases

import android.annotation.SuppressLint
import com.example.marvelcomics.data.ComicRepository
import com.example.marvelcomics.domain.Character
import com.example.marvelcomics.framework.models.CharacterRawModel
import com.example.marvelcomics.usecases.models.convertToCharacter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class GetCharacter(private val comicRepository: ComicRepository) {

    @SuppressLint("CheckResult")
    operator fun invoke(name: String, onSuccess: (Character) -> Unit, onError: (Throwable) -> Unit) {
        comicRepository.getCharacterByName(name)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeWith(object : DisposableSingleObserver<CharacterRawModel>() {
                override fun onSuccess(character: CharacterRawModel) {
                    onSuccess(character.convertToCharacter())
                }

                override fun onError(e: Throwable) {
                    onError(e)
                }

            })

    }
}