package com.app.wordsphrases.edit_word_impl.presentation.ui.model

import com.app.wordsphrases.core_ui.ui.adapter.AnyDiffItem

data class TranslationUiModel(
    val id: Int,
    val text: String,
    val showDeleteButton: Boolean,
): AnyDiffItem {

    override fun isSame(newItem: AnyDiffItem): Boolean {
        return newItem is TranslationUiModel &&
            id == newItem.id
    }

    override fun isContentSame(newItem: AnyDiffItem): Boolean {
        return this == newItem
    }
}