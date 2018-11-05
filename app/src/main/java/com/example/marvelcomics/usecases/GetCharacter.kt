package com.example.marvelcomics.usecases

import android.annotation.SuppressLint
import com.example.marvelcomics.data.ComicRepository
import com.example.marvelcomics.domain.Character
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class GetCharacter(private val comicRepository: ComicRepository) {

    @SuppressLint("CheckResult")
    operator fun invoke(name: String, onSuccess: (Character) -> Unit, onError: (Throwable) -> Unit) {
        comicRepository.getCharacterByName(name)
            .observeOn(Schedulers.newThread())
            .subscribeOn(Schedulers.newThread())
            .subscribeWith(object : DisposableSingleObserver<Character>() {
                override fun onSuccess(character: Character) {
                    onSuccess(character)
                }

                override fun onError(e: Throwable) {
                    onError(e)
                }

            })

    }
}