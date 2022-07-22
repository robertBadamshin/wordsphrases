package com.app.wordsphrases.words_stories_impl.presentation.ui.model

import com.app.wordsphrases.core_ui.ui.adapter.AnyDiffItem
import com.wordphrases.domain.entity.WordId

data class WordUiModel(
    val wordId: WordId,
    val text: String,
    val translations: List<String>,
    val comment: String?,
    val colorSchemaUiModel: WordColorSchemaUiModel,
) : AnyDiffItem {

    override fun isSame(newItem: AnyDiffItem): Boolean {
        return newItem is WordUiModel && wordId == newItem.wordId
    }

    override fun isContentSame(newItem: AnyDiffItem): Boolean {
        return this == newItem
    }
}