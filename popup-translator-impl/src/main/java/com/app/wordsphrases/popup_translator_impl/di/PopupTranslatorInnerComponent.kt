package com.app.wordsphrases.popup_translator_impl.di

import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

interface PopupTranslatorInnerComponent {

    @get:PopupTranslatorNavigationQualifier
    val popupTranslationRouter: Router

    @get:PopupTranslatorNavigationQualifier
    val popupTranslatorNavigatorHolder: NavigatorHolder
}