package com.app.wordsphrases.add_word_impl.di.inner

import com.app.wordsphrases.add_word_api.domain.entity.InitialTextWrapper
import com.app.wordsphrases.add_word_impl.di.AddWordNavigationQualifier
import com.app.wordsphrases.core.di.FeatureScope
import dagger.*
import ru.terrakok.cicerone.Router

@FeatureScope
@Component
interface RegularAddWordInnerComponent : AddWordInnerComponent {

    companion object {
        fun get(router: Router, initialTextWrapper: InitialTextWrapper): RegularAddWordInnerComponent {
            return DaggerRegularAddWordInnerComponent.factory()
                .create(
                    router,
                    initialTextWrapper,
                )
        }
    }

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance @AddWordNavigationQualifier router: Router,
            @BindsInstance initialTextWrapper: InitialTextWrapper,
        ): RegularAddWordInnerComponent
    }
}