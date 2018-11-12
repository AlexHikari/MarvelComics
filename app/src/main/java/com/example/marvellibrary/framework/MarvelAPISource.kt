package com.example.marvelcomics.framework

import com.example.marvelcomics.BuildConfig
import com.example.marvelcomics.data.ComicSource
import com.example.marvelcomics.domain.Comic
import com.example.marvelcomics.framework.models.CharacterRawModel
import io.reactivex.Maybe
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.security.MessageDigest

class MarvelAPISource : ComicSource {
    private val marvelAPI: MarvelAPI

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://gateway.marvel.com:443")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        marvelAPI = retrofit.create(MarvelAPI::class.java)
    }

    private fun byteArrayToHexString(array: Array<Byte>): String {
        var result = StringBuilder(array.size * 2)
        for (byte in array) {
            val toAppend: String = String.format("%2X", byte).replace(" ", "0")
            result.append(toAppend)
        }
        result.setLength(result.length)
        return result.toString()
    }

    private fun hashString(text: String): String {
        var result: String
        result = try {
            var md: MessageDigest = MessageDigest.getInstance("MD5")
            md.reset()
            var digestedHash: Array<Byte> = md.digest(text.toByteArray()).toTypedArray()
            byteArrayToHexString(digestedHash)

        } catch (e: Exception) {
            ""
        }
        return result.toLowerCase()
    }

    override fun getCharacterByName(name: String): Maybe<CharacterRawModel> {
        var ts: String = System.currentTimeMillis().toString()
        var hash = hashString(ts + BuildConfig.marvelPrivateApiKey + BuildConfig.marvelPublicApiKey)
        return marvelAPI.getCharacter(ts, name, BuildConfig.marvelPublicApiKey, hash).flatMapMaybe { characterRawMode ->
            Maybe.create<CharacterRawModel> {
                if (characterRawMode.data.character.isEmpty()) {
                    it.onComplete()
                } else {
                    it.onSuccess(characterRawMode)
                }
            }

        }
    }

    override fun getComicByCharacterId(characterId: Int): Single<List<Comic>> {
        TODO("GET not implemented yet")
    }

}