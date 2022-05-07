package com.app.wordsphrases.translation_impl.data.entity.oxford

import com.google.gson.annotations.SerializedName

data class OxfordTranslationResultItemRemote(
    @SerializedName("text")
    val text: String,
    @SerializedName("oxfordGrammaticalFeatures")
    val oxfordGrammaticalFeatures: List<OxfordGrammaticalFeatures>?,
)