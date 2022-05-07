package com.app.wordsphrases.translation_impl.data.entity.oxford

import com.google.gson.annotations.SerializedName

data class OxfordTranslationLexicalEntriesRemote(
    @SerializedName("entries")
    val entries: List<OxfordTranslationLexicalEntryRemote>,
)