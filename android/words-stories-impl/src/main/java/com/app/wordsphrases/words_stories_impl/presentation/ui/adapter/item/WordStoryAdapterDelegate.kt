package com.app.wordsphrases.words_stories_impl.presentation.ui.adapter.item

import android.annotation.SuppressLint
import android.graphics.drawable.GradientDrawable
import android.util.TypedValue
import android.view.*
import android.widget.*
import androidx.core.content.ContextCompat
import com.app.wordsphrases.core_ui.ui.adapter.AnyDiffItem
import com.app.wordsphrases.core_ui.view.dpToPx
import com.app.wordsphrases.words_stories_impl.R
import com.app.wordsphrases.words_stories_impl.presentation.ui.model.WordUiModel
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegate

object WordStoryAdapterDelegate {

    @SuppressLint("ClickableViewAccessibility")
    operator fun invoke(): AdapterDelegate<List<AnyDiffItem>> {
        return adapterDelegate<WordUiModel, AnyDiffItem>(R.layout.item_word_story) {

            val rootContainer: View = findViewById(R.id.root_container_word_story)
            val wordTextView: TextView = findViewById(R.id.text_view_word_text)
            val translationLinearLayout: LinearLayout = findViewById(
                R.id.linear_layout_word_translations
            )
            val commentTextView: TextView = findViewById(R.id.text_view_word_comment)

            bind {
                val colorSchemaUiModel = item.colorSchemaUiModel
                val backgroundColor = ContextCompat.getColor(
                    context,
                    colorSchemaUiModel.backgroundColorRes,
                )
                rootContainer.setBackgroundColor(backgroundColor)

                val wordTextColor = ContextCompat.getColor(
                    context,
                    colorSchemaUiModel.wordTextColorRes,
                )
                wordTextView.setTextColor(wordTextColor)
                wordTextView.text = item.text

                commentTextView.text = item.comment
                commentTextView.setTextColor(wordTextColor)

                translationLinearLayout.removeAllViews()

                val translationTextColor = ContextCompat.getColor(
                    context,
                    colorSchemaUiModel.translationTextColorRes,
                )
                val translationsBackgroundColor = ContextCompat.getColor(
                    context,
                    colorSchemaUiModel.translationBackgroundColorRes,
                )

                item.translations.forEach { translation ->
                    val translationTextView = TextView(context)

                    val layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                    )
                    layoutParams.gravity = Gravity.CENTER
                    layoutParams.topMargin = 16.dpToPx()
                    translationTextView.layoutParams = layoutParams

                    translationTextView.text = translation
                    translationTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16f)

                    val translationBackgroundDrawable = ContextCompat.getDrawable(
                        context,
                        R.drawable.drawable_word_story_text_background
                    ) as GradientDrawable
                    translationBackgroundDrawable.setColor(translationsBackgroundColor)
                    translationTextView.background = translationBackgroundDrawable

                    translationTextView.setTextColor(translationTextColor)
                    translationTextView.setTextColor(translationTextColor)

                    translationLinearLayout.addView(translationTextView)
                }
            }
        }
    }
}