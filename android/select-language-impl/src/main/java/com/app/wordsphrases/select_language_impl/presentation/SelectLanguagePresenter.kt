package com.app.wordsphrases.select_language_impl.presentation

import com.app.wordsphrases.select_language_impl.R
import com.app.wordsphrases.select_language_impl.domain.use_case.*
import com.app.wordsphrases.select_language_impl.presentation.ui.model.mapper.LanguagesUiMapper
import com.wordphrases.domain.entity.language.Language
import kotlinx.coroutines.flow.*
import moxy.*
import javax.inject.Inject

class SelectLanguagePresenter @Inject constructor(
    private val getSelectedLanguageEnvironment: GetSelectedLanguageEnvironment,
    private val languagesUiMapper: LanguagesUiMapper,
    private val setSelectedLanguage: SetSelectedLanguage,
) : MvpPresenter<SelectLanguageView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        getSelectedLanguageEnvironment()
            .map { environment -> languagesUiMapper.map(environment) }
            .onEach { uiModels -> viewState.showLanguages(uiModels) }
            .launchIn(presenterScope)
    }

    fun onLanguageSelected(language: Language) {
        setSelectedLanguage(language)
    }

    fun onScrollStateChanged(firstItemVisibleIndex: Int) {
        val targetColorAttr = if (firstItemVisibleIndex == 0) {
            R.attr.surface
        } else {
            R.attr.rainbow
        }

        viewState.startHeaderBackgroundAnimation(targetColorAttr)
    }
}