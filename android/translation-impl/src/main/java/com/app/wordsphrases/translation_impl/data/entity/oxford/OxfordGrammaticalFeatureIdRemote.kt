package com.app.wordsphrases.translation_impl.data.entity.oxford

import com.app.wordsphrases.translation_impl.domain.OxfordGrammaticalFeatureId
import com.google.gson.annotations.SerializedName

enum class OxfordGrammaticalFeatureIdRemote {
    @SerializedName("imperfective")
    Imperfective,
}

fun OxfordGrammaticalFeatureIdRemote?.toTranslationsList(): OxfordGrammaticalFeatureId? {
    return when (this) {
        OxfordGrammaticalFeatureIdRemote.Imperfective -> OxfordGrammaticalFeatureId.Imperfective
        null -> null
    }
}