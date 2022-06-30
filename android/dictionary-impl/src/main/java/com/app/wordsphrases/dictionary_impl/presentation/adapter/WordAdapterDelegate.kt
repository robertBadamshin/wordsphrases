package com.app.wordsphrases.dictionary_impl.presentation.adapter

import android.widget.TextView
import com.app.wordsphrases.core_ui.ui.adapter.AnyDiffItem
import com.app.wordsphrases.dictionary_impl.R
import com.app.wordsphrases.dictionary_impl.presentation.ui.WordUiModel
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegate
import com.wordphrases.domain.entity.WordId

object WordAdapterDelegate {

    operator fun invoke(
        onLanguageSelected: (WordId) -> Unit,
    ): AdapterDelegate<List<AnyDiffItem>> {
        return adapterDelegate<WordUiModel, AnyDiffItem>(R.layout.item_word) {

            val wordTextView: TextView = findViewById(R.id.text_view_word_text)
            val translationsTextView: TextView = findViewById(R.id.text_view_word_translations)

            bind {
                wordTextView.text = item.wordText
                translationsTextView.text = item.translationsText

                itemView.setOnClickListener { onLanguageSelected(item.wordId) }
            }
        }
    }
}