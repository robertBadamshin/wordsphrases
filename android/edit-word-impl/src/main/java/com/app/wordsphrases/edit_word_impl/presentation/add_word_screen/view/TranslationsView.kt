package com.app.wordsphrases.edit_word_impl.presentation.add_word_screen.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.app.wordsphrases.edit_word_impl.R
import com.app.wordsphrases.edit_word_impl.presentation.ui.model.TranslationUiModel
import com.app.wordsphrases.core_ui.view.showKeyboard

class TranslationsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    var onLostFocus: (() -> Unit)? = null
    var onFindFocus: ((translationId: Int) -> Unit)? = null
    var onTextUpdate: ((text: String) -> Unit)? = null
    var onRemoveClick: ((translationId: Int) -> Unit)? = null

    init {
        orientation = VERTICAL
    }

    fun bind(uiModels: List<TranslationUiModel>) {
        val childCount = childCount
        val uiModelsListSize = uiModels.size

        if (childCount > uiModelsListSize) {
            val start = uiModelsListSize - 1
            val count = childCount - 1 - start
            removeViewsInLayout(start, count)
        }

        uiModels.forEachIndexed { index, uiModel ->
            var view: TranslationView? = getChildAt(index) as TranslationView?
            if (view == null) {
                view = View.inflate(
                    context,
                    R.layout.item_translation_view,
                    null
                ) as TranslationView

                initView(view)

                val layoutParams = generateDefaultLayoutParams()
                addViewInLayout(view, index, layoutParams, true)
            }

            view.bind(uiModel)
        }

        requestLayout()
    }

    private fun initView(view: TranslationView) {
        view.onLostFocus = onLostFocus
        view.onFindFocus = onFindFocus
        view.onTextUpdate = onTextUpdate
        view.onRemoveClick = onRemoveClick

        view.removeSelfFromParent = { viewToRemove ->
            if (viewToRemove.isInputFocused()) {
                val indexOfChild = indexOfChild(viewToRemove)
                if (indexOfChild == -1) {
                    throw IllegalStateException("child not presented in parent")
                }

                val childIndexToFocus = if (indexOfChild > 0) {
                    indexOfChild - 1
                } else {
                    indexOfChild + 1
                }

                val childToFocus = getChildAt(childIndexToFocus) as TranslationView
                childToFocus.requestFocus()
                childToFocus.showKeyboard()
            }

            removeView(viewToRemove)
        }
    }
}