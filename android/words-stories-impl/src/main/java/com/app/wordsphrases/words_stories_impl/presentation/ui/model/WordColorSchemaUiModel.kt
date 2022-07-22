package com.app.wordsphrases.words_stories_impl.presentation.ui.model

import androidx.annotation.ColorRes
import com.app.wordsphrases.core_ui.ui.adapter.AnyDiffItem

data class WordColorSchemaUiModel(
    @ColorRes
    val backgroundColorRes: Int,
    @ColorRes
    val wordTextColorRes: Int,
    @ColorRes
    val translationTextColorRes: Int,
    @ColorRes
    val translationBackgroundColorRes: Int,
) : AnyDiffItem {

    override fun isSame(newItem: AnyDiffItem): Boolean {
        return newItem is WordColorSchemaUiModel
    }

    override fun isContentSame(newItem: AnyDiffItem): Boolean {
        return this == newItem
    }
}