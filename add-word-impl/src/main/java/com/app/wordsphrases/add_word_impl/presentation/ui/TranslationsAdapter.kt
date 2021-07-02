package com.app.wordsphrases.add_word_impl.presentation.ui

import com.app.wordsphrases.core_ui.ui.adapter.AnyDiffItem
import com.app.wordsphrases.core_ui.ui.adapter.SimpleDiffUtilCallback
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class TranslationsAdapter : AsyncListDifferDelegationAdapter<AnyDiffItem>(
    SimpleDiffUtilCallback<AnyDiffItem>(),
    TranslationWordDelegateAdapter(),
)