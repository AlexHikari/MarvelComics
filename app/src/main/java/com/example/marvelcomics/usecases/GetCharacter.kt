package com.example.marvelcomics.usecases

import com.example.marvelcomics.data.ComicRepository
import com.example.marvelcomics.domain.Character
import io.reactivex.Single

import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver

class GetCharacter(private val comicRepository: ComicRepository) {

    operator fun invoke(name: String): Character {

        val characterSingle: Single<Character> =  comicRepository.getCharacterByName(name)
         val disposable: Disposable = characterSingle.subscribeWith(object: DisposableSingleObserver<Character>(){
             override fun onSuccess(t: Character) {
                 TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
             }

             override fun onError(e: Throwable) {
                 TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
             }

         })

    }
}