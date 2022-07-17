package com.app.wordsphrases.words_stories_impl.presentation.ui.adapter

import com.app.wordsphrases.core_ui.ui.adapter.*
import com.app.wordsphrases.words_stories_impl.presentation.ui.adapter.item.WordStoryAdapterDelegate
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class WordsStoriesAdapter(
    onNextClicked: () -> Unit,
    onPrevClicked: () -> Unit,
) : AsyncListDifferDelegationAdapter<AnyDiffItem>(
    SimpleDiffUtilCallback(),
    WordStoryAdapterDelegate(
        onNextClicked = onNextClicked,
        onPrevClicked = onPrevClicked,
    ),
)