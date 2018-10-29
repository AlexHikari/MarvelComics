package com.example.marvelcomics.usecases

import com.example.marvelcomics.data.ComicRepository
import com.example.marvelcomics.domain.Character
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver

class GetCharacter(private val comicRepository: ComicRepository) {

    operator fun invoke(name: String, onSuccess: (Character) -> Unit, onError: (Throwable) -> Unit) {
        val characterSingle: Single<Character> = comicRepository.getCharacterByName(name)
        val disposable: Disposable = characterSingle.subscribeWith(object : DisposableSingleObserver<Character>() {
            override fun onSuccess(character: Character) {
                onSuccess(character)
            }

            override fun onError(e: Throwable) {
                onError(e)
            }

        })

    }
}