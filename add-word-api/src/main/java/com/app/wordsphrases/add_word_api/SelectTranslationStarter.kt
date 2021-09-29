package com.app.wordsphrases.add_word_api

import com.app.wordsphrases.add_word_api.domain.entity.AddWordComponentType
import ru.terrakok.cicerone.android.support.SupportAppScreen

interface SelectTranslationStarter {

    fun getScreen(type: AddWordComponentType): SupportAppScreen
}