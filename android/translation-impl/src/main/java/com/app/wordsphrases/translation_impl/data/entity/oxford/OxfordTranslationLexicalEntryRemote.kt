package com.app.wordsphrases.translation_impl.data.entity.oxford

import com.google.gson.annotations.SerializedName

data class OxfordTranslationLexicalEntryRemote(
    @SerializedName("senses")
    val senses: List<OxfordTranslationSenseRemote>?,
)