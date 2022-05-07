package com.app.wordsphrases.translation_impl.data.entity.oxford

import com.google.gson.annotations.SerializedName

data class OxfordTranslationSenseRemote(
    @SerializedName("translations")
    val translations: List<OxfordTranslationResultItemRemote>,
)