package com.app.wordsphrases.translation_impl.domain.entity

import com.app.wordsphrases.translation_impl.domain.OxfordGrammaticalFeatureId

data class OxfordTranslation(
    val text: String,
    val featureIds: List<OxfordGrammaticalFeatureId>,
)