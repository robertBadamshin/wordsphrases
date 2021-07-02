package com.app.wordsphrases.translation_impl.data.service

import com.app.wordsphrases.entity.ResultWrapper
import com.app.wordsphrases.translation_impl.data.entity.TranslationResultRemote
import retrofit2.http.GET
import retrofit2.http.Query

interface TranslationService {
    @GET("Api.aspx")
    suspend fun getTranslation(
        @Query("Name") name: String = "Translate",
        @Query("text") text: String,
    ): ResultWrapper<TranslationResultRemote>
}