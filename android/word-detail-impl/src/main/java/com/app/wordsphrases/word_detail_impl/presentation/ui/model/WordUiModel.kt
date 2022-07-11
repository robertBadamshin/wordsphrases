package com.app.wordsphrases.word_detail_impl.presentation.ui.model

    data class WordUiModel(
    val dictionaryLanguages: String,
    val wordText: String,
    val translations: List<String>,
    val comment: String?,
)