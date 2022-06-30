package com.app.wordsphrases.add_word_impl.presentation.add_word_screen

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.activity.OnBackPressedCallback
import androidx.core.widget.doAfterTextChanged
import com.app.wordsphrases.add_word_impl.R
import com.app.wordsphrases.add_word_impl.di.AddWordParentComponent
import com.app.wordsphrases.add_word_impl.presentation.add_word_screen.view.TranslationsView
import com.app.wordsphrases.add_word_impl.presentation.ui.model.TranslationUiModel
import com.app.wordsphrases.core_ui.view.*
import com.google.android.material.color.MaterialColors
import com.google.android.material.floatingactionbutton.FloatingActionButton
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import java.util.*

private const val addWordComponentUuidKey = "addWordComponentUuid"

class AddWordFragment : MvpAppCompatFragment(), AddWordView {

    private val presenter by moxyPresenter {
        val uuid = requireArguments().getSerializable(addWordComponentUuidKey) as? UUID
            ?: throw IllegalStateException("addWordComponentUuid should be presented")

        val addWordComponent = AddWordParentComponent.get().requireAddWordComponent(uuid)
        return@moxyPresenter addWordComponent.addWordPresenter
    }

    private lateinit var arrowCloseImageView: ImageView
    private lateinit var wordTextEditText: EditText
    private lateinit var commentTextEditText: EditText
    private lateinit var translationsView: TranslationsView
    private lateinit var addWordFab: FloatingActionButton

    private val enabledButtonColor by lazy {
        MaterialColors.getColor(addWordFab, R.attr.rainbow)
    }
    private val disabledButtonColor by lazy {
        MaterialColors.getColor(addWordFab, R.attr.rainbow_60)
    }

    private val backPressedCallback = object : OnBackPressedCallback(true) {

        override fun handleOnBackPressed() {
            presenter.onBackPressed()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(this, backPressedCallback)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_add_word, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arrowCloseImageView = view.findViewById(R.id.image_view_close_enter_word)
        arrowCloseImageView.setOnClickListener { requireActivity().onBackPressed() }

        wordTextEditText = view.findViewById(R.id.edit_text_enter_word)

        translationsView = view.findViewById(R.id.translations_view_word)
        translationsView.onLostFocus = { presenter.onLostTranslateFocus() }
        translationsView.onFindFocus = { translationId ->
            presenter.onFindTranslateFocus(translationId)
        }
        translationsView.onTextUpdate = { text: String ->
            presenter.onInputTranslate(text)
        }
        translationsView.onRemoveClick = { translationId: Int ->
            presenter.onRemoveTranslationClick(translationId)
        }

        addWordFab = view.findViewById(R.id.fab_add_word)
        addWordFab.setOnClickListener {
            presenter.onAddWordClick()
        }

        wordTextEditText.doAfterTextChanged { editableText ->
            presenter.onWordChanged(editableText.toString())
        }

        commentTextEditText = view.findViewById(R.id.edit_text_enter_comment)
        commentTextEditText.doAfterTextChanged { editableText ->
            presenter.onCommentChanged(editableText.toString())
        }

        presenter.onWordChanged(wordTextEditText.text.toString())

        view.configureInsets()
    }

    override fun onResume() {
        super.onResume()
        presenter.showKeyboard()
    }

    override fun setAddWordButtonEnabled() {
        addWordFab.backgroundTintList = ColorStateList.valueOf(enabledButtonColor)
        addWordFab.isEnabled = true
    }

    override fun setAddWordButtonDisabled() {
        addWordFab.backgroundTintList = ColorStateList.valueOf(disabledButtonColor)
        addWordFab.isEnabled = false
    }

    override fun showKeyboard() {
        wordTextEditText.showKeyboard()
    }

    override fun setInitialText(text: String) {
        wordTextEditText.setText(text)
    }

    override fun showTranslations(uiModels: List<TranslationUiModel>) {
        translationsView.bind(uiModels)
    }

    override fun showToastMessage(messageRes: Int) {
        Toast.makeText(requireContext(), messageRes, Toast.LENGTH_SHORT).show()
    }

    companion object {

        fun newInstance(uuid: UUID): AddWordFragment {
            val arguments = Bundle().apply {
                putSerializable(addWordComponentUuidKey, uuid)
            }

            return AddWordFragment().apply {
                setArguments(arguments)
            }
        }
    }
}