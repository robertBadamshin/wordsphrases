package com.app.wordsphrases.translation_impl.domain

import com.app.wordsphrases.translation_api.domain.TranslationResult
import com.app.wordsphrases.translation_impl.data.repository.TranslateTextRepository
import com.google.gson.Gson
import okhttp3.OkHttpClient
import java.io.IOException
import javax.inject.Inject

private const val endpoint = "https://od-api.oxforddictionaries.com/api/v2/translations"

class TranslateTextByOxfordDictionary @Inject constructor(
    private val translateTextRepository: TranslateTextRepository,
) {

    private val client = OkHttpClient()
    private val gson = Gson()

    @Throws(IOException::class)
    suspend operator fun invoke(text: String): TranslationResult {
        return translateTextRepository.translateText("en", "ru", text)
        /*
        val additionalUrl = "/en/ru/$text?strictMatch=true&fields=translations"

        val request = Request.Builder()
            .url(endpoint + additionalUrl)
            .addHeader("app_key", "8c6f07ebe370921a2a37bb9bdf414848")
            .addHeader("app_id", "6bcf397e")
            .addHeader("Accept", "application/json").build()

        val response = client.newCall(request).execute()

        val responseString = response.body()!!.string()
        val type = object : TypeToken<OxfordTranslationResponse>() {}.type
        val resultRemote = gson.fromJson<OxfordTranslationResponse>(responseString, type)

        val firstResult = resultRemote.results.first()
        val translationsTexts = firstResult
            .lexicalEntries
            .flatMap { lexicalEntryWrapper ->

                lexicalEntryWrapper.entries.flatMap { lexicalEntry ->

                    lexicalEntry.senses.orEmpty().flatMap { sense ->
                        val resultText = sense.translations
                            .filter { translation ->
                                if (translation.oxfordGrammaticalFeatures == null) {
                                    return@filter true
                                }

                                translation.oxfordGrammaticalFeatures.any { feature -> feature.id != OxfordGrammaticalFeatureIdRemote.Imperfective }
                            }
                            .map { translation ->
                                translation.text
                            }

                        resultText
                    }
                }
            }

        var id = 0
        val translations = translationsTexts
            .map { translationText ->
                Normalizer.normalize(translationText, Normalizer.Form.NFD)
                    .replace("[^\\p{ASCII}]", "")
            }
            .distinct()
            .map { translationText ->
                Translation(
                    id = id++,
                    text = translationText,
                )
            }

        return TranslationResult(
            translations = translations,
        )*/
    }
}