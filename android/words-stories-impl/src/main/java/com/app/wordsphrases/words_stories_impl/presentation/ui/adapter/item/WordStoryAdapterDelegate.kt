package com.app.wordsphrases.words_stories_impl.presentation.ui.adapter.item

import android.annotation.SuppressLint
import android.view.*
import android.widget.*
import com.app.wordsphrases.core_ui.ui.adapter.AnyDiffItem
import com.app.wordsphrases.words_stories_impl.R
import com.app.wordsphrases.words_stories_impl.presentation.ui.model.WordUiModel
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegate

object WordStoryAdapterDelegate {

    @SuppressLint("ClickableViewAccessibility")
    operator fun invoke(
        onNextClicked: () -> Unit,
        onPrevClicked: () -> Unit,
    ): AdapterDelegate<List<AnyDiffItem>> {
        return adapterDelegate<WordUiModel, AnyDiffItem>(R.layout.item_word_story) {

            val rootContainer: View = findViewById(R.id.root_container_word_story)
            val wordTextView: TextView = findViewById(R.id.text_view_word_text)
            val translationLinearLayout: LinearLayout = findViewById(
                R.id.linear_layout_word_translations
            )
            val commentTextView: TextView = findViewById(R.id.text_view_word_comment)

            val gestureDetector = GestureDetector(
                context,
                object : GestureDetector.SimpleOnGestureListener() {

                    override fun onSingleTapUp(event: MotionEvent): Boolean {
                        if (event.x < rootContainer.width / 2) {
                            onPrevClicked()
                        } else {
                            onNextClicked()
                        }

                        return true
                    }

                    override fun onDown(e: MotionEvent?): Boolean {
                        return true
                    }
                }
            )
            rootContainer.setOnTouchListener { _, event ->
                gestureDetector.onTouchEvent(event)
            }

            bind {
                wordTextView.text = item.text

                commentTextView.text = item.comment
            }
        }
    }
}