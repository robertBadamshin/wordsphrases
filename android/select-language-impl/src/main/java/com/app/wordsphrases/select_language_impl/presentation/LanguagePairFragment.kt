package com.app.wordsphrases.select_language_impl.presentation

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.setFragmentResultListener
import com.app.wordsphrases.select_language_impl.R
import com.app.wordsphrases.select_language_impl.di.LanguagePairComponent
import com.app.wordsphrases.select_language_impl.presentation.ui.model.LanguagePairUiModel
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class LanguagePairFragment : MvpAppCompatFragment(), LanguagePairView {

    private val languagePairPresenter by moxyPresenter {
        LanguagePairComponent.get().languagePairPresenter
    }

    private lateinit var learningLangageTextView: TextView
    private lateinit var nativeLanguageTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_languages_pair, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        learningLangageTextView = view.findViewById(R.id.text_view_learning_language)
        nativeLanguageTextView = view.findViewById(R.id.text_view_native_language)

        learningLangageTextView.setOnClickListener {
            languagePairPresenter.onLearningLanguageClick()
        }

        nativeLanguageTextView.setOnClickListener {
            languagePairPresenter.onNativeLanguageClick()
        }
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
        learningLangageTextView.text = uiModel.learningLanguageText
        nativeLanguageTextView.text = uiModel.nativeLanguageText
    }
}