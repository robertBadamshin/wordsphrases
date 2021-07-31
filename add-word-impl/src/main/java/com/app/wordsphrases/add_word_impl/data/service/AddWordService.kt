package com.app.wordsphrases.add_word_impl.data.service

import com.app.wordsphrases.add_word_impl.data.entity.remote.AddWordResultRemote
import com.app.wordsphrases.add_word_impl.data.entity.request.AddWordRequest
import com.app.wordsphrases.entity.ResultWrapper
import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface AddWordService {

    @POST("Api.aspx")
    suspend fun addWord(request: AddWordRequest): ResultWrapper<AddWordResultRemote>
}