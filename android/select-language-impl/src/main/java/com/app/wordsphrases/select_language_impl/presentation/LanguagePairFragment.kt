package com.app.wordsphrases.select_language_impl.presentation

import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.setFragmentResultListener
import com.app.wordsphrases.core_ui.view.configureInsets
import com.app.wordsphrases.select_language_impl.R
import com.app.wordsphrases.select_language_impl.di.LanguagePairComponent
import com.app.wordsphrases.select_language_impl.presentation.ui.model.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class LanguagePairFragment : MvpAppCompatFragment(), LanguagePairView {

    private val languagePairPresenter by moxyPresenter {
        LanguagePairComponent.get().languagePairPresenter
    }

    private lateinit var learningLanguageTextView: TextView
    private lateinit var nativeLanguageTextView: TextView
    private lateinit var createPairButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_languages_pair, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        learningLanguageTextView = view.findViewById(R.id.text_view_learning_language)
        nativeLanguageTextView = view.findViewById(R.id.text_view_native_language)
        createPairButton = view.findViewById(R.id.button_create_language_pair)

        learningLanguageTextView.setOnClickListener {
            languagePairPresenter.onLearningLanguageClick()
        }

        nativeLanguageTextView.setOnClickListener {
            languagePairPresenter.onNativeLanguageClick()
        }

        createPairButton.setOnClickListener { languagePairPresenter.onSaveLanguagePairClick() }

        view.configureInsets()
    }

    override fun startListenForNativeLanguageResult(key: String) {
        setFragmentResultListener(key) { _, bundle ->
            val resultLanguage = SelectLanguageFragment.getLanguageResultFromBundle(bundle)
            languagePairPresenter.onNativeLanguageSelected(resultLanguage)
        }
    }

    override fun startListenForLearningLanguageResult(key: String) {
        setFragmentResultListener(key) { _, bundle ->
            val resultLanguage = SelectLanguageFragment.getLanguageResultFromBundle(bundle)
            languagePairPresenter.onLearningLanguageSelected(resultLanguage)
        }
    }

    override fun setLanguages(uiModel: LanguagePairUiModel) {
        learningLanguageTextView.text = uiModel.learningLanguageText
        val learningTextAppearance = when (uiModel.learningTextType) {
            LanguagePairTextType.Default -> R.style.TextStyle_Regular_Secondary_22dp
            LanguagePairTextType.Selected -> R.style.TextStyle_Regular_Primary_22dp
        }
        learningLanguageTextView.setTextAppearance(learningTextAppearance)

        nativeLanguageTextView.text = uiModel.nativeLanguageText
        val nativeTextAppearance = when (uiModel.nativeTextType) {
            LanguagePairTextType.Default -> R.style.TextStyle_Regular_Secondary_22dp
            LanguagePairTextType.Selected -> R.style.TextStyle_Regular_Primary_22dp
        }
        nativeLanguageTextView.setTextAppearance(nativeTextAppearance)

        val createPairButtonEnabled = uiModel.learningTextType == LanguagePairTextType.Selected &&
            uiModel.nativeTextType == LanguagePairTextType.Selected
        createPairButton.isEnabled = createPairButtonEnabled
    }
}