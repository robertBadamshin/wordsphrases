package com.app.wordsphrases.dictionary_impl.presentation.adapter

import com.app.wordsphrases.core_ui.ui.adapter.*
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.wordphrases.domain.entity.WordId
import com.wordphrases.domain.entity.language.Language

class WordsAdapter(
    onWordClick: (WordId) -> Unit,
) : AsyncListDifferDelegationAdapter<AnyDiffItem>(
    SimpleDiffUtilCallback(),
    LanguageAdapterDelegate(onWordClick)
)