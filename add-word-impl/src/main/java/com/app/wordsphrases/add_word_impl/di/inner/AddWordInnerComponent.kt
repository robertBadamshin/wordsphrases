package com.app.wordsphrases.add_word_impl.di.inner

import com.app.wordsphrases.add_word_api.domain.entity.InitialTextWrapper
import com.app.wordsphrases.add_word_impl.di.AddWordNavigationQualifier
import ru.terrakok.cicerone.Router

interface AddWordInnerComponent {

    @get:AddWordNavigationQualifier
    val router: Router

    val initialTextWrapper: InitialTextWrapper
}