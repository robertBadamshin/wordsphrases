package com.app.wordsphrases.edit_word_impl.presentation.add_word_screen.view

import android.content.Context
import android.text.*
import android.util.AttributeSet
import android.widget.*
import androidx.core.view.isInvisible
import androidx.core.widget.*
import com.app.wordsphrases.edit_word_impl.R
import com.app.wordsphrases.edit_word_impl.presentation.ui.model.TranslationUiModel

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

    private val textWatcher = object: TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(editable: Editable) {
            onTextUpdate?.invoke(editable.toString())
        }

    }

    init {
        orientation = HORIZONTAL
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        translationEditText = findViewById(R.id.edit_text_translation)
        removeTranslationImageView = findViewById(R.id.image_view_remove_translation)
    }

    fun bind(uiModel: TranslationUiModel) {
        translationEditText.removeTextChangedListener(textWatcher)

        translationEditText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                onFindFocus?.invoke(uiModel.id)
            } else {
                onLostFocus?.invoke()
            }
        }

        if (translationEditText.text.toString() != uiModel.text) {
            translationEditText.setText(uiModel.text)
        }

        removeTranslationImageView.isInvisible = !uiModel.showDeleteButton
        removeTranslationImageView.setOnClickListener {
            removeSelfFromParent?.invoke(this)
            onRemoveClick?.invoke(uiModel.id)
        }

        translationEditText.addTextChangedListener(textWatcher)
    }

    fun isInputFocused(): Boolean {
        return translationEditText.isFocused
    }
}