package com.app.wordsphrases.translation_impl.data.entity.oxford

import com.google.gson.annotations.SerializedName

data class OxfordTranslationResultRemote(
    @SerializedName("lexicalEntries")
    val lexicalEntries: List<OxfordTranslationLexicalEntriesRemote>,
)