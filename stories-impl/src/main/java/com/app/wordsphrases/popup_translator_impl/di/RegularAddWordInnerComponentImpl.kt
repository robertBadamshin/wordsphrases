package com.app.wordsphrases.popup_translator_impl.di

import com.app.wordsphrases.add_word_api.di.AddWordInnerComponent
import com.app.wordsphrases.add_word_api.di.AddWordNavigationQualifier
import com.app.wordsphrases.core.di.FeatureScope
import dagger.BindsInstance
import dagger.Component
import ru.terrakok.cicerone.Router

@FeatureScope
@Component
interface RegularAddWordInnerComponentImpl : AddWordInnerComponent {

    companion object {

        fun get(router: Router): RegularAddWordInnerComponentImpl {
            return DaggerRegularAddWordInnerComponentImpl.factory()
                .create(router)
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance @AddWordNavigationQualifier router: Router,
        ): RegularAddWordInnerComponentImpl
    }
}