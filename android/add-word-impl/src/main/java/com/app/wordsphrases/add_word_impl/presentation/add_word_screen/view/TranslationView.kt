package com.app.wordsphrases.add_word_impl.presentation.add_word_screen.view

import android.content.Context
import android.util.AttributeSet
import android.widget.*
import androidx.core.view.isInvisible
import androidx.core.widget.doAfterTextChanged
import com.app.wordsphrases.add_word_impl.R
import com.app.wordsphrases.add_word_impl.presentation.ui.model.TranslationUiModel

class TranslationView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private lateinit var translationEditText: EditText
    private lateinit var removeTranslationImageView: ImageView

    var onLostFocus: (() -> Unit)? = null
    var onFindFocus: ((translationId: Int) -> Unit)? = null
    var onTextUpdate: ((text: String) -> Unit)? = null
    var onRemoveClick: ((translationId: Int) -> Unit)? = null
    var removeSelfFromParent: ((viewToRemove: TranslationView) -> Unit)? = null

    init {
        orientation = HORIZONTAL
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        translationEditText = findViewById(R.id.edit_text_translation)
        removeTranslationImageView = findViewById(R.id.image_view_remove_translation)

        translationEditText.doAfterTextChanged { editable ->
            onTextUpdate?.invoke(editable.toString())
        }
    }

    fun bind(uiModel: TranslationUiModel) {
        translationEditText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                onFindFocus?.invoke(uiModel.id)
            } else {
                onLostFocus?.invoke()
            }
        }

        removeTranslationImageView.isInvisible = !uiModel.showDeleteButton
        removeTranslationImageView.setOnClickListener {
            removeSelfFromParent?.invoke(this)
            onRemoveClick?.invoke(uiModel.id)
        }
    }

    fun isInputFocused(): Boolean {
        return translationEditText.isFocused
    }
}