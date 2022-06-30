package com.app.wordsphrases.dictionary_impl.presentation

import com.app.wordsphrases.dictionary_impl.presentation.ui.mapper.WordUiMapper
import com.app.wordsphrases.select_language_impl.R
import com.app.wordsphrases.select_language_impl.domain.entity.SelectLanguageType
import com.app.wordsphrases.select_language_impl.domain.use_case.GetLanguages
import com.app.wordsphrases.select_language_impl.presentation.ui.model.mapper.LanguagesUiMapper
import com.wordphrases.domain.entity.language.Language
import com.wordphrases.domain.usecase.GetAllWordsForDictionary
import com.wordphrases.domain.usecase.language_pair.*
import kotlinx.coroutines.flow.*
import moxy.*
import javax.inject.Inject

class DictionaryPresenter @Inject constructor(
    private val wordUiMapper: WordUiMapper,
    private val getAllWordsForDictionary: GetAllWordsForDictionary,
    private val getSelectedLanguagePair: GetSelectedLanguagePair,
) : MvpPresenter<DictionaryView>() {

    private lateinit var selectLanguageType: SelectLanguageType

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        updateWords()
    }

    private fun updateWords() {
        getSelectedLanguagePair()
            .flatMapLatest { languagePair -> getAllWordsForDictionary(languagePair.pairId) }
            .map { words -> wordUiMapper.map(words) }
            .onEach { uiModels -> viewState.setWords(uiModels) }
            .launchIn(presenterScope)
    }
}