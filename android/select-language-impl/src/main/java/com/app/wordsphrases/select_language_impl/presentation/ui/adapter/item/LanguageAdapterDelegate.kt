package com.app.wordsphrases.select_language_impl.presentation.ui.adapter.item

import android.widget.*
import com.app.wordsphrases.core_ui.ui.adapter.AnyDiffItem
import com.app.wordsphrases.select_language_impl.R
import com.app.wordsphrases.select_language_impl.presentation.ui.model.LanguageUiModel
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegate
import com.wordphrases.domain.entity.language.Language

object LanguageAdapterDelegate {

    operator fun invoke(
        onLanguageSelected: (Language) -> Unit,
    ): AdapterDelegate<List<AnyDiffItem>> {
        return adapterDelegate<LanguageUiModel, AnyDiffItem>(R.layout.item_language) {

            val selectRadioButton: RadioButton = findViewById(R.id.radio_button_language_item)
            val nameTextView: TextView = findViewById(R.id.text_view_language_name_item)

            bind {
                selectRadioButton.setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked) {
                        onLanguageSelected(item.language)
                    }
                }

                selectRadioButton.isChecked = item.selected
                nameTextView.text = item.name
            }
        }
    }
}