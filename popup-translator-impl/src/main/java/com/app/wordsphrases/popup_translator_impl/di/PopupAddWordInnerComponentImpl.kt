package com.app.wordsphrases.popup_translator_impl.di

import com.app.wordsphrases.add_word_api.di.AddWordInnerComponent
import com.app.wordsphrases.core.di.FeatureScope
import dagger.Component

@FeatureScope
@Component(
    modules = [
        PopupTranslatorRouterModule::class,
    ],
)
interface PopupAddWordInnerComponentImpl : AddWordInnerComponent, PopupTranslatorInnerComponent {

    companion object {
        fun get(): PopupAddWordInnerComponentImpl {
            return DaggerPopupAddWordInnerComponentImpl.builder().build()
        }
    }
}