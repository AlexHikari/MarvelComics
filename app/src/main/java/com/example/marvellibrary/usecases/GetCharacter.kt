package com.example.marvellibrary.usecases

import android.annotation.SuppressLint
import com.example.marvellibrary.data.ComicRepository
import com.example.marvellibrary.domain.Character
import com.example.marvellibrary.framework.models.CharacterRawModel
import com.example.marvellibrary.usecases.models.convertToCharacter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableMaybeObserver
import io.reactivex.schedulers.Schedulers

class GetCharacter(private val comicRepository: ComicRepository) {

    @SuppressLint("CheckResult")
    operator fun invoke(
        name: String,
        onSuccess: (Character) -> Unit,
        onEmpty: () -> Unit,
        onError: (Throwable) -> Unit
    ) {
        comicRepository.getCharacterByName(name)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeWith(object : DisposableMaybeObserver<CharacterRawModel>() {
                override fun onComplete() {
                    onEmpty()
                }

                override fun onSuccess(character: CharacterRawModel) {
                    onSuccess(character.convertToCharacter())
                }

                override fun onError(e: Throwable) {
                    onError(e)
                }
            })

    }
}