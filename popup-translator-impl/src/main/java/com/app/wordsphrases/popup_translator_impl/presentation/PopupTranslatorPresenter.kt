package com.app.wordsphrases.popup_translator_impl.presentation

import com.app.wordsphrases.add_word_api.EnterWordStarter
import com.app.wordsphrases.add_word_api.di.AddWordInnerComponent
import com.app.wordsphrases.add_word_api.domain.entity.AddWordComponentType
import com.app.wordsphrases.popup_translator_impl.domain.entity.PopupTranslatorRouterWrapper
import moxy.MvpPresenter
import javax.inject.Inject

class PopupTranslatorPresenter @Inject constructor(
    private val popupTranslatorRouterWrapper: PopupTranslatorRouterWrapper,
    private val enterWordStarter: EnterWordStarter,
) : MvpPresenter<PopupTranslatorView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.beginPopupAddWordComponentCreation()
    }

    fun initPopupAddWordComponent(component: AddWordInnerComponent) {
        enterWordStarter.initComponent(AddWordComponentType.Popup, component)

        val screen = enterWordStarter.getScreen(AddWordComponentType.Popup)
        popupTranslatorRouterWrapper.router.navigateTo(screen)
    }
}