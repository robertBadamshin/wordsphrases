package com.app.wordsphrases.word_detail_impl.presentation

import com.app.wordsphrases.core.di.MainNavigationQualifier
import com.app.wordsphrases.edit_word_api.*
import com.app.wordsphrases.edit_word_api.domain.entity.EditWordType
import com.app.wordsphrases.word_detail_impl.domain.entity.WordIdHolder
import com.app.wordsphrases.word_detail_impl.presentation.ui.model.mapper.WordUiMapper
import com.wordphrases.domain.usecase.word.GetWordById
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class WordDetailsPresenter @Inject constructor(
    @MainNavigationQualifier private val router: Router,
    private val getWordById: GetWordById,
    private val wordUiMapper: WordUiMapper,
    private val wordIdHolder: WordIdHolder,
    private val editWordStarter: EditWordStarter,
) : MvpPresenter<WordDetailsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        val word = getWordById(wordIdHolder.wordId)
        val uiModel = wordUiMapper.map(word)
        viewState.showWord(uiModel)
    }

    fun onBackPressed() {
        router.exit()
    }

    fun onEditWordClick() {
        val type = EditWordType.EditWord(wordIdHolder.wordId)
        val initParams = EditWordInitParams(type)
        val screen = editWordStarter.getScreen(initParams)
        router.navigateTo(screen)
    }
}