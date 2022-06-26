package com.app.wordsphrases.add_word_impl.presentation.add_word_screen.view

import android.content.Context
import android.util.AttributeSet
import android.view.*
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.widget.doAfterTextChanged
import com.app.wordsphrases.add_word_impl.R
import com.app.wordsphrases.add_word_impl.presentation.ui.model.TranslationUiModel

class TranslationsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val crossDrawable by lazy { ContextCompat.getDrawable(context, R.drawable.ic_cross) }

    var onLostFocus: (() -> Unit)? = null
    var onTextUpdate: ((String) -> Unit)? = null

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
            var view = getChildAt(index)
            if (view == null) {
                view = inflate(context, R.layout.item_translation_view, null)
                val layoutParams = getLayoutParams(view)
                addViewInLayout(view, index, layoutParams, true)
            }

            val castedView = view as? EditText
            if (castedView == null) {
                throw IllegalStateException("view in container has wrong type. View: $castedView")
            }

            bindView(castedView, uiModel)
        }

        requestLayout()
    }

    private fun getLayoutParams(view: View): ViewGroup.LayoutParams? {
        return if (view.layoutParams != null) {
            view.layoutParams
        } else {
            generateDefaultLayoutParams()
        }
    }

    private fun bindView(editText: EditText, uiModel: TranslationUiModel) {
        val drawableEnd = if (uiModel.showDeleteButton) {
            crossDrawable
        } else {
            null
        }
        editText.setCompoundDrawables(null, null, drawableEnd, null)

        editText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                onLostFocus?.invoke()
            }
        }

        editText.doAfterTextChanged { text -> onTextUpdate?.invoke(text.toString()) }
    }
}