package com.app.wordsphrases.add_word_impl.presentation.ui

import android.widget.TextView
import com.app.wordsphrases.add_word_impl.R
import com.app.wordsphrases.add_word_impl.presentation.ui.model.TranslationUiModel
import com.app.wordsphrases.core_ui.ui.adapter.AnyDiffItem
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegate

object TranslationWordDelegateAdapter {

    operator fun invoke(): AdapterDelegate<List<AnyDiffItem>> {
        return adapterDelegate<TranslationUiModel, AnyDiffItem>(R.layout.item_translation_text) {

            val translationTextView: TextView = findViewById(R.id.text_view_translation_text)

            bind {
                translationTextView.text = item.text
            }
        }
    }
}