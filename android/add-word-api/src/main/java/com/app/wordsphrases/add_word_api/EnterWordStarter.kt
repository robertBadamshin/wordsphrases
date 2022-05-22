package com.app.wordsphrases.add_word_api

import com.app.wordsphrases.add_word_api.domain.entity.*
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppScreen

interface EnterWordStarter {

    fun getScreen(
        type: AddWordComponentType,
        router: Router,
        initialTextWrapper: InitialTextWrapper,
    ): SupportAppScreen
}