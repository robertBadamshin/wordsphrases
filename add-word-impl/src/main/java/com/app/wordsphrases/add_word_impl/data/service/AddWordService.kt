package com.app.wordsphrases.add_word_impl.data.service

import com.app.wordsphrases.add_word_impl.data.entity.remote.AddWordResultRemote
import com.app.wordsphrases.entity.ResultWrapper
import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface AddWordService {

    @Multipart
    @POST("Api.aspx")
    suspend fun getTranslation(
        @Part("Name") name: String = "Translate",
        @Part("tgId") telegramId: Long = 365529102,
        @Part("word") word: String,
        @Part("translation") translation: String,
        @Part("img") image: MultipartBody.Part,
    ): ResultWrapper<AddWordResultRemote>
}