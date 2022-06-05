package com.app.wordsphrases.select_language_impl.presentation.ui.model

import com.app.wordsphrases.core_ui.ui.adapter.AnyDiffItem
import com.wordphrases.domain.entity.language.Language

data class LanguageUiModel(
    val name: String,
    val language: Language,
    val selected: Boolean,
) : AnyDiffItem {

    override fun isSame(newItem: AnyDiffItem): Boolean {
        return newItem is LanguageUiModel && language == newItem.language
    }

    override fun isContentSame(newItem: AnyDiffItem): Boolean {
        return this == newItem
    }
}