package com.app.wordsphrases.translation_impl.domain

import com.app.wordsphrases.translation_api.domain.TranslationResult
import com.app.wordsphrases.translation_impl.data.entity.TranslationItemRemote
import com.app.wordsphrases.translation_impl.data.entity.TranslationResultRemote
import com.app.wordsphrases.translation_impl.data.entity.toDomainEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import java.io.IOException
import java.util.ArrayList
import javax.inject.Inject

private const val subscriptionKey = "aa7e0d04bfba4658a6ed362782768bc0"
private const val endpoint = "https://api-eur.cognitive.microsofttranslator.com"
private const val url = "$endpoint/dictionary/lookup?api-version=3.0&from=en&to=ru"

class TranslateTextByMicrosoft @Inject constructor() {

    private val client = OkHttpClient()
    private val gson = Gson()

    @Throws(IOException::class)
    operator fun invoke(text: String): TranslationResult {
        /*val mediaType = MediaType.parse("application/json")
        val body = RequestBody.create(
            mediaType,
            "[{\"Text\": \"$text\"}]"
        )
        val request = Request.Builder()
            .url(url)
            .post(body)
            .addHeader("Ocp-Apim-Subscription-Key", subscriptionKey)
            .addHeader("Content-type", "application/json").build()
        val response = client.newCall(request).execute()

        val responseString = response.body()!!.string()
        val type = object : TypeToken<ArrayList<TranslationResultRemote>>() {}.type
        val resultRemote = gson.fromJson<List<TranslationResultRemote>>(responseString, type)*/

        val translationResultRemote = TranslationResultRemote(
            translations = listOf(
                TranslationItemRemote(
                    text = "translation",
                    confidence = 0.5f,
                )
            )
        )
        //return resultRemote.first().toDomainEntity()
        return translationResultRemote.toDomainEntity()
    }
}