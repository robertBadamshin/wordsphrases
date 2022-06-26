package com.app.wordsphrases.add_word_impl.presentation.select_translation_fragment

import com.app.wordsphrases.add_word_api.domain.entity.AddWordComponentType
import com.app.wordsphrases.add_word_impl.R
import com.app.wordsphrases.add_word_impl.di.AddWordNavigationQualifier
import com.app.wordsphrases.add_word_impl.domain.use_case.*
import com.app.wordsphrases.add_word_impl.presentation.ui.model.mapper.WordTopMarginUiMapper
import kotlinx.coroutines.launch
import moxy.*
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class SelectTranslationPresenter @Inject constructor(
    @AddWordNavigationQualifier private val router: Router,
    private val getCurrentWordText: GetCurrentWordText,
    private val onSaveWordClick: OnSaveWordClick,
    private val addWordComponentType: AddWordComponentType,
    private val wordTopMarginUiMapper: WordTopMarginUiMapper
) : MvpPresenter<SelectTranslationView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        updateWord()
        autoSelectTranslation()
        setWordTopMargin()
    }

    private fun setWordTopMargin() {
        val paddingUiModel = wordTopMarginUiMapper.map(addWordComponentType)
        viewState.setWordToMargin(paddingUiModel)
    }

    private fun autoSelectTranslation() {
        presenterScope.launch {
        }
    }

    private fun updateWord() {
        presenterScope.launch {
            val wordText = getCurrentWordText()
            viewState.setWordText(wordText)
        }
    }

    fun onAddWordClicked() {
        presenterScope.launch {
            onSaveWordClick()
            viewState.showToastMessage(R.string.word_added)
            router.newRootChain()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}