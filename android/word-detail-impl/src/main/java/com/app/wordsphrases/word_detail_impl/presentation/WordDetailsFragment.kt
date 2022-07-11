package com.app.wordsphrases.word_detail_impl.presentation

import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.activity.OnBackPressedCallback
import com.app.wordsphrases.core_ui.view.*
import com.app.wordsphrases.word_detail_impl.R
import com.app.wordsphrases.word_detail_impl.di.WordDetailsComponent
import com.app.wordsphrases.word_detail_impl.domain.entity.WordIdHolder
import com.app.wordsphrases.word_detail_impl.presentation.ui.model.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.wordphrases.domain.entity.WordId
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import java.util.*

private const val wordIdKey = "wordIdKey"

class WordDetailsFragment : MvpAppCompatFragment(), WordDetailsView {

    private val presenter by moxyPresenter {
        val wordId = requireArguments().getLong(wordIdKey)
        val wordIdHolder = WordIdHolder(wordId)
        return@moxyPresenter WordDetailsComponent.get(wordIdHolder).wordDetailsPresenter
    }

    private lateinit var arrowCloseImageView: ImageView
    private lateinit var dictionaryTextView: TextView
    private lateinit var wordTextView: TextView
    private lateinit var commentTextView: TextView
    private lateinit var translationsLinearLayout: LinearLayout
    private lateinit var editWordFab: FloatingActionButton

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
        return inflater.inflate(R.layout.fragment_word_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arrowCloseImageView = view.findViewById(R.id.image_view_close_word)
        arrowCloseImageView.setOnClickListener { requireActivity().onBackPressed() }

        dictionaryTextView = view.findViewById(R.id.text_view_title_dictionary)

        wordTextView = view.findViewById(R.id.text_view_word_text)

        translationsLinearLayout = view.findViewById(R.id.linear_layout_translations)

        editWordFab = view.findViewById(R.id.fab_edit_word)
        editWordFab.setOnClickListener {
            presenter.onEditWordClick()
        }

        commentTextView = view.findViewById(R.id.text_view_comment)

        view.configureInsets()
    }

    companion object {

        fun newInstance(wordId: WordId): WordDetailsFragment {
            val arguments = Bundle().apply {
                putLong(wordIdKey, wordId)
            }

            return WordDetailsFragment().apply {
                setArguments(arguments)
            }
        }
    }

    override fun showWord(uiModel: WordUiModel) {
        dictionaryTextView.text = uiModel.dictionaryLanguages
        wordTextView.text = uiModel.wordText

        translationsLinearLayout.removeAllViews()
        val layoutInflater = LayoutInflater.from(context)

        uiModel.translations.map { translation ->
            val translationView = layoutInflater.inflate(
                R.layout.item_word_detail_translation_view,
                translationsLinearLayout,
                false
            )
            val translationTextView = translationView.findViewById<TextView>(
                R.id.text_view_translation_text
            )
            translationTextView.text = translation

            translationsLinearLayout.addView(translationView)
        }

        commentTextView.text = uiModel.comment
    }
}