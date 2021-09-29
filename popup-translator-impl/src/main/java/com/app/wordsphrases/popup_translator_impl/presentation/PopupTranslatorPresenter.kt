package com.app.wordsphrases.popup_translator_impl.presentation

import com.app.wordsphrases.add_word_api.EnterWordStarter
import com.app.wordsphrases.add_word_api.di.AddWordInnerComponent
import com.app.wordsphrases.add_word_api.domain.entity.AddWordComponentType
import com.app.wordsphrases.popup_translator_impl.di.PopupTranslatorNavigationQualifier
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class PopupTranslatorPresenter @Inject constructor(
    @PopupTranslatorNavigationQualifier private val router: Router,
    private val enterWordStarter: EnterWordStarter,
) : MvpPresenter<PopupTranslatorView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.beginPopupAddWordComponentCreation()
    }

    fun initPopupAddWordComponent(component: AddWordInnerComponent) {
        enterWordStarter.initComponent(AddWordComponentType.Popup, component)

        val screen = enterWordStarter.getScreen(AddWordComponentType.Popup)
        router.navigateTo(screen)
    }

    fun onBackStackChanged(count: Int) {
        if (count == 0) {
            router.exit()
        }
    }
}