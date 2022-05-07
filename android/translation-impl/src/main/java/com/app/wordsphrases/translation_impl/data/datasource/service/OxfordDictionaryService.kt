package com.app.wordsphrases.translation_impl.data.datasource.service

import com.app.wordsphrases.translation_impl.data.entity.oxford.OxfordTranslationResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface OxfordDictionaryService {

    @GET("{from}/{to}/{text}?strictMatch=true&fields=translations")
    suspend fun translateWord(
        @Path("from") from: String = "en",
        @Path("to") to: String = "ru",
        @Path("text") text: String,
    ): OxfordTranslationResponse
}