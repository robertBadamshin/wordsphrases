package com.app.wordsphrases.add_word_impl.data.entity.request

import com.google.gson.annotations.SerializedName

data class AddWordRequest(
    @SerializedName("Name")
    val name: String = "Translate",
    @SerializedName("tgId")
    val telegramId: Long = 365529102,
    @SerializedName("word")
    val text: String,
    @SerializedName("translation")
    val translation: String,
    @SerializedName("img")
    val image: String?,
)