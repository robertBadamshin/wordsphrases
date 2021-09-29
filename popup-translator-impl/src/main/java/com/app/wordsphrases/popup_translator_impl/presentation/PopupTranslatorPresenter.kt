package com.app.wordsphrases.popup_translator_impl.presentation

import com.app.wordsphrases.add_word_api.EnterWordStarter
import com.app.wordsphrases.add_word_api.di.AddWordInnerComponent
import com.app.wordsphrases.add_word_api.domain.CreatePopupAddWordComponent
import com.app.wordsphrases.popup_translator_impl.domain.entity.PopupTranslatorRouterWrapper
import moxy.MvpPresenter
import javax.inject.Inject

class PopupTranslatorPresenter @Inject constructor(
    private val popupTranslatorRouterWrapper: PopupTranslatorRouterWrapper,
    private val enterWordStarter: EnterWordStarter,
    private val createPopupAddWordComponent: CreatePopupAddWordComponent,
) : MvpPresenter<PopupTranslatorView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.beginPopupAddWordComponentCreation()

        val screen = enterWordStarter.getScreen()
        popupTranslatorRouterWrapper.router.navigateTo(screen)
    }

    fun initPopupAddWordComponent(component: AddWordInnerComponent) {
        createPopupAddWordComponent(component)
    }
}