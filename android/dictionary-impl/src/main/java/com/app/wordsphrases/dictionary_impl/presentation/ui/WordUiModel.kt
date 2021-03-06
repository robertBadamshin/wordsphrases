package com.app.wordsphrases.dictionary_impl.presentation.ui

import com.app.wordsphrases.core_ui.ui.adapter.AnyDiffItem
import com.wordphrases.domain.entity.WordId

data class WordUiModel(
    val wordId: WordId,
    val wordText: String,
    val translationsText: String,
) : AnyDiffItem