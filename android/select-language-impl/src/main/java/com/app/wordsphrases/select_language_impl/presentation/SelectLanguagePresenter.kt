package com.app.wordsphrases.select_language_impl.presentation

import com.app.wordsphrases.select_language_impl.R
import com.app.wordsphrases.select_language_impl.domain.entity.SelectLanguageType
import com.app.wordsphrases.select_language_impl.domain.use_case.GetLanguages
import com.app.wordsphrases.select_language_impl.presentation.ui.model.mapper.LanguagesUiMapper
import com.wordphrases.domain.entity.language.Language
import kotlinx.coroutines.flow.*
import moxy.*
import javax.inject.Inject

class SelectLanguagePresenter @Inject constructor(
    private val getLanguages: GetLanguages,
    private val languagesUiMapper: LanguagesUiMapper,
) : MvpPresenter<SelectLanguageView>() {

    private lateinit var selectLanguageType: SelectLanguageType

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        updateLanguages()

        initTitle()
    }

    fun init(selectLanguageType: SelectLanguageType) {
        this.selectLanguageType = selectLanguageType
    }

    private fun updateLanguages() {
        getLanguages()
            .map { languages -> languagesUiMapper.map(languages) }
            .onEach { uiModels -> viewState.showLanguages(uiModels) }
            .launchIn(presenterScope)
    }

    private fun initTitle() {
        val titleResId = when (selectLanguageType) {
            SelectLanguageType.Learning -> R.string.learning_language_title
            SelectLanguageType.Native -> R.string.native_language_title
        }
        viewState.setTitle(titleResId)
    }

    fun onLanguageSelected(language: Language) {
        // todo pass result
    }
}