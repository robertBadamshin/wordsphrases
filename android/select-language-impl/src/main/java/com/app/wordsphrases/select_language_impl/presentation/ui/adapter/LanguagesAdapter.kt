package com.app.wordsphrases.select_language_impl.presentation.ui.adapter

import com.app.wordsphrases.core_ui.ui.adapter.*
import com.app.wordsphrases.select_language_impl.presentation.ui.adapter.item.LanguageAdapterDelegate
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.wordphrases.domain.entity.language.Language

class LanguagesAdapter(
    onLanguageSelected: (Language) -> Unit,
) : AsyncListDifferDelegationAdapter<AnyDiffItem>(
    SimpleDiffUtilCallback(),
    LanguageAdapterDelegate(onLanguageSelected)
)